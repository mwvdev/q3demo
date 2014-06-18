package mwvdev.quake.models;

import mwvdev.quake.exceptions.LoaderException;

import java.util.ArrayList;
import java.util.List;

public class Message
{

    private int sequence;
    private int length;
    private int acknowledge;

    private GameState gameState;
    private List<ServerCommand> serverCommands = new ArrayList<>();
    private Snapshot snapshot;

    public int getSequence()
    {
        return sequence;
    }

    public void setSequence( int sequence )
    {
        this.sequence = sequence;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength( int length )
    {
        this.length = length;
    }

    public int getAcknowledge()
    {
        return acknowledge;
    }

    public void setAcknowledge( int acknowledge )
    {
        this.acknowledge = acknowledge;
    }

    public GameState getGameState()
    {
        return gameState;
    }

    public void setGameState( GameState gameState )
    {
        this.gameState = gameState;
    }

    public List<ServerCommand> getServerCommands()
    {
        return serverCommands;
    }

    public Snapshot getSnapshot()
    {
        return snapshot;
    }

    public void setSnapshot( Snapshot snapshot )
    {
        this.snapshot = snapshot;
    }

}
