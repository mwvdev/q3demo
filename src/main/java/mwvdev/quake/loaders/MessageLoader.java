package mwvdev.quake.loaders;

import mwvdev.quake.buffer.BitBuffer;
import mwvdev.quake.constants.ServerToClientCommand;
import mwvdev.quake.exceptions.LoaderException;
import mwvdev.quake.huffman.HuffmanDecoder;
import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.GameState;
import mwvdev.quake.models.Message;
import mwvdev.quake.models.ServerCommand;
import mwvdev.quake.models.Snapshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;

public class MessageLoader
{

    private static final Logger logger = LoggerFactory.getLogger( DemoLoader.class );

    private static final int maxMessageLength = 0x4000;

    private final ReadableByteChannel channel;

    public MessageLoader( ReadableByteChannel channel )
    {
        this.channel = channel;
    }

    public Message loadMessage( ReadableByteChannel channel )
    {
        Message message = new Message();

        ByteBuffer encodedBuffer = ByteBuffer.allocate( 8 );
        encodedBuffer.order( ByteOrder.LITTLE_ENDIAN );

        try
        {
            channel.read( encodedBuffer );
        }
        catch( IOException e )
        {
            throw new LoaderException( e );
        }

        encodedBuffer.flip();

        message.setSequence( encodedBuffer.getInt() );
        if( message.getSequence() == -1  )
        {
            return null;
        }

        message.setLength( encodedBuffer.getInt() );
        if( message.getLength() == -1  )
        {
            return null;
        }

        if( message.getLength() == 0 && message.getLength() >= maxMessageLength )
        {
            throw new LoaderException( "Invalid demo message length encountered" );
        }

        encodedBuffer = ByteBuffer.allocateDirect( message.getLength() );
        encodedBuffer.order( ByteOrder.LITTLE_ENDIAN );

        int bytesRead;
        try
        {
            bytesRead = channel.read( encodedBuffer );
        }
        catch( IOException e )
        {
            throw new LoaderException( e );
        }

        if( bytesRead != message.getLength() )
        {
            throw new LoaderException( "Invalid demo file encountered, possibly truncated." );
        }

        logger.info( "Loaded message: {} Length: {}", message.getSequence(), message.getLength() );

        encodedBuffer.flip();

        HuffmanDecoder huffmanDecoder = new HuffmanDecoder( new BitBuffer( encodedBuffer ) );
        HuffmanReader huffmanReader = new HuffmanReader( huffmanDecoder );

        message.setAcknowledge( huffmanReader.readInt() );

        byte command = huffmanReader.readByte();
        while( command != ServerToClientCommand.SVC_EOM )
        {
            logger.info( "\tParsing message command: {}", command );

            switch( command )
            {
                case ServerToClientCommand.SVC_GAMESTATE:
                {
                    GameStateLoader gameStateLoader = new GameStateLoader();
                    GameState gameState = gameStateLoader.loadGameState( huffmanReader );

                    message.setGameState( gameState );
                }
                break;
                case ServerToClientCommand.SVC_SERVERCOMMAND:
                {
                    ServerCommandLoader serverCommandLoader = new ServerCommandLoader();
                    ServerCommand serverCommand = serverCommandLoader.loadServerCommand( huffmanReader );

                    message.getServerCommands().add( serverCommand );
                }
                break;
                case ServerToClientCommand.SVC_SNAPSHOT:
                {
                    SnapshotLoader snapshotLoader = new SnapshotLoader();
                    Snapshot snapshot = snapshotLoader.loadSnapshot( huffmanReader );

                    message.setSnapshot( snapshot );
                }
                break;
                case ServerToClientCommand.SVC_NOP:
                {
                    // No operation, ignore
                }
                break;
                case ServerToClientCommand.SVC_BASELINE:
                case ServerToClientCommand.SVC_CONFIGSTRING:
                case ServerToClientCommand.SVC_DOWNLOAD:
                default:
                {
                    throw new LoaderException( "Invalid demo message command encountered." );
                }
            }

            command = huffmanReader.readByte();
        }

        logger.info( "Message acknowledge: {}", message.getAcknowledge() );

        return message;
    }

}
