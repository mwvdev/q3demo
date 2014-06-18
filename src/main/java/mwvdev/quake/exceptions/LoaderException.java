package mwvdev.quake.exceptions;

public class LoaderException extends RuntimeException
{

    public LoaderException()
    {
        super();
    }

    public LoaderException( String message )
    {
        super( message );
    }

    public LoaderException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public LoaderException( Throwable cause )
    {
        super( cause );
    }

}
