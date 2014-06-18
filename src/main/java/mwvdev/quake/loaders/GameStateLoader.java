package mwvdev.quake.loaders;

import mwvdev.quake.constants.GameStateConstants;
import mwvdev.quake.constants.ServerToClientCommand;
import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.EntityState;
import mwvdev.quake.models.GameState;

public class GameStateLoader
{

    public GameState loadGameState( HuffmanReader huffmanReader )
    {
        GameState gameState = new GameState();
        gameState.setSequence( huffmanReader.readInt() );

        byte command = huffmanReader.readByte();
        if( command == -1 )
        {
            throw new RuntimeException( "Invalid gamestate encountered." );
        }

        while( command != ServerToClientCommand.SVC_EOM )
        {
            switch( command )
            {
                case ServerToClientCommand.SVC_CONFIGSTRING:
                {
                    int index = huffmanReader.readShort();

                    if( index < 0 || index > GameStateConstants.MAX_CONFIGSTRINGS )
                    {
                        throw new RuntimeException( "Invalid config string index encountered." );
                    }

                    gameState.getConfigStrings().put( index, huffmanReader.readString() );
                }
                break;
                case ServerToClientCommand.SVC_BASELINE:
                {
                    int entityNumber = huffmanReader.readBits( 10 );

                    EntityStateLoader entityStateLoader = new EntityStateLoader();
                    EntityState entityState = entityStateLoader.loadEntityState( huffmanReader, entityNumber );

                    gameState.getEntityStates().add( entityState );
                }
                break;
                default:
                    throw new RuntimeException( "Unknown command encountered: " + command );
            }

            command = huffmanReader.readByte();
        }

        gameState.setClientNumber( huffmanReader.readInt() );
        gameState.setChecksum( huffmanReader.readInt() );

        return gameState;
    }

}
