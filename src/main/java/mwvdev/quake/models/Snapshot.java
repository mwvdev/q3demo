package mwvdev.quake.models;

import java.util.ArrayList;
import java.util.List;

public class Snapshot
{

    private static final int MAX_MAP_AREA_BYTES = 32;

    private int flags;

    private int serverTime;

    private byte[] areaMask = new byte[MAX_MAP_AREA_BYTES];

    private PlayerState playerState;

    private List<EntityState> entityStates = new ArrayList<>();

    public int getFlags()
    {
        return flags;
    }

    public void setFlags( int flags )
    {
        this.flags = flags;
    }

    public int getServerTime()
    {
        return serverTime;
    }

    public void setServerTime( int serverTime )
    {
        this.serverTime = serverTime;
    }

    public byte[] getAreaMask()
    {
        return areaMask;
    }

    public void setAreaMask( byte[] areaMask )
    {
        this.areaMask = areaMask;
    }

    public PlayerState getPlayerState()
    {
        return playerState;
    }

    public void setPlayerState( PlayerState playerState )
    {
        this.playerState = playerState;
    }

    public List<EntityState> getEntityStates()
    {
        return entityStates;
    }

    public void setEntityStates( List<EntityState> entityStates )
    {
        this.entityStates = entityStates;
    }

}
