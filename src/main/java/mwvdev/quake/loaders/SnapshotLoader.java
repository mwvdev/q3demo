package mwvdev.quake.loaders;

import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.EntityState;
import mwvdev.quake.models.Snapshot;

public class SnapshotLoader
{

    public Snapshot loadSnapshot( HuffmanReader huffmanReader )
    {
        Snapshot snapshot = new Snapshot();

        snapshot.setServerTime( huffmanReader.readInt() );

        // The delta sequence is ignored
        huffmanReader.readByte();

        snapshot.setFlags( huffmanReader.readByte() );
        int areaMaskLength = huffmanReader.readByte();
        snapshot.setAreaMask( huffmanReader.readBytes( areaMaskLength ) );

        PlayerStateLoader playerStateLoader = new PlayerStateLoader();
        snapshot.setPlayerState( playerStateLoader.loadPlayerState( huffmanReader ) );

        EntityStateLoader entityStateLoader = new EntityStateLoader();

        int entityNumber = huffmanReader.readBits( 10 );
        while( entityNumber < 1023 )
        {
            EntityState entityState = entityStateLoader.loadEntityState( huffmanReader, entityNumber );

            if( entityState != null )
            {
                snapshot.getEntityStates().add( entityState );
            }

            entityNumber = huffmanReader.readBits( 10 );
        }

        return snapshot;
    }

}
