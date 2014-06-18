package mwvdev.quake.constants;

public final class ServerToClientCommand
{

    public static final int SVC_BAD = 0;
    public static final int SVC_NOP = 1;
    public static final int SVC_GAMESTATE = 2;
    public static final int SVC_CONFIGSTRING = 3;
    public static final int SVC_BASELINE = 4;
    public static final int SVC_SERVERCOMMAND = 5;
    public static final int SVC_DOWNLOAD = 6;
    public static final int SVC_SNAPSHOT = 7;
    public static final int SVC_EOM = 8;

    private ServerToClientCommand()
    {

    }

}
