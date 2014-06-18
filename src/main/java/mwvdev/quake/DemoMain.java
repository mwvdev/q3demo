package mwvdev.quake;

import mwvdev.quake.exceptions.HuffmanException;
import mwvdev.quake.exceptions.LoaderException;
import mwvdev.quake.loaders.DemoLoader;

public class DemoMain
{

    public static void main( String[] args )
    {
        if( args.length < 2 )
        {
            System.out.println( "A demo filename is required." );
            return;
        }

        String demoFilename = args[1];

        try
        {
            DemoLoader demoLoader = new DemoLoader();
            demoLoader.loadDemo( demoFilename );
        }
        catch( HuffmanException | LoaderException e )
        {
            System.out.println( e.getMessage() );
        }
    }

}
