package mwvdev.quake.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameState
{

    private int sequence;

    private Map<Integer, String> configStrings = new HashMap<>();
    private List<EntityState> entityStates = new ArrayList<>();

    private int clientNumber;
    private int checksum;

    public int getSequence()
    {
        return sequence;
    }

    public void setSequence( int sequence )
    {
        this.sequence = sequence;
    }

    public Map<Integer, String> getConfigStrings()
    {
        return configStrings;
    }

    public List<EntityState> getEntityStates()
    {
        return entityStates;
    }

    public int getClientNumber()
    {
        return clientNumber;
    }

    public void setClientNumber( int clientNumber )
    {
        this.clientNumber = clientNumber;
    }

    public int getChecksum()
    {
        return checksum;
    }

    public void setChecksum( int checksum )
    {
        this.checksum = checksum;
    }

}
