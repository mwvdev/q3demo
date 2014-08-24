package mwvdev.quake.loaders;

import mwvdev.quake.exceptions.LoaderException;
import mwvdev.quake.models.Demo;
import mwvdev.quake.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DemoLoader
{

    private static final Logger logger = LoggerFactory.getLogger( DemoLoader.class );

    public Demo loadDemo( String demoFilename )
    {
        logger.info( "Loading demo: ", demoFilename );

        InputStream inputStream;
        try
        {
            inputStream = new FileInputStream( demoFilename );
        }
        catch( FileNotFoundException e )
        {
            throw new LoaderException( e );
        }

        return loadDemo( Channels.newChannel( inputStream ) );
    }

    public Demo loadDemo( ReadableByteChannel channel )
    {
        Demo demo = new Demo();

        MessageLoader messageLoader = new MessageLoader();
        Message message = messageLoader.loadMessage( channel );
        while( message != null )
        {
            demo.getMessages().add( message );

            message = messageLoader.loadMessage( channel );
        }

        return demo;
    }

}
