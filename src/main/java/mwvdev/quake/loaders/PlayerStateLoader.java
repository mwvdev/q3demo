package mwvdev.quake.loaders;

import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.PlayerState;

public class PlayerStateLoader
{

    private static final int GENTITYNUM_BITS = 10;

    private PlayerStateFieldReader[] playerStateFieldReaders = {
        ( ( playerState, huffmanReader ) -> playerState.setCommandTime( huffmanReader.readInt() ) ),
        ( ( playerState, huffmanReader ) -> playerState.getOrigin()[0] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.getOrigin()[1] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.setBobCycle( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.getVelocity()[0] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.getVelocity()[1] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.getViewAngles()[1] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.getViewAngles()[0] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.setWeaponTime( huffmanReader.readSignedShort() ) ),
        ( ( playerState, huffmanReader ) -> playerState.getOrigin()[2] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.getVelocity()[2] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.setLegsTimer( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setPmTime( huffmanReader.readSignedShort() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setEventSequence( huffmanReader.readShort() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setTorsoAnim( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setMovementDir( huffmanReader.readBits( 4 ) ) ),
        ( ( playerState, huffmanReader ) -> playerState.getEvents()[0] = (int) huffmanReader.readByte() ),
        ( ( playerState, huffmanReader ) -> playerState.setLegsAnim( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.getEvents()[1] = (int) huffmanReader.readByte() ),
        ( ( playerState, huffmanReader ) -> playerState.setPmFlags( huffmanReader.readShort() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setGroundEntityNum( huffmanReader.readBits( GENTITYNUM_BITS ) ) ),
        ( ( playerState, huffmanReader ) -> playerState.setWeaponstate( huffmanReader.readBits( 4 ) ) ),
        ( ( playerState, huffmanReader ) -> playerState.seteFlags( huffmanReader.readShort() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setExternalEvent( huffmanReader.readBits( 10 ) ) ),
        ( ( playerState, huffmanReader ) -> playerState.setGravity( huffmanReader.readShort() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setSpeed( huffmanReader.readShort() ) ),
        ( ( playerState, huffmanReader ) -> playerState.getDeltaAngles()[1] = huffmanReader.readShort() ),
        ( ( playerState, huffmanReader ) -> playerState.setExternalEventParm( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setViewHeight( (int) huffmanReader.readSignedByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setDamageEvent( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setDamageYaw( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setDamagePitch( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setDamageCount( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setGeneric1( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setPmType( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.getDeltaAngles()[0] = huffmanReader.readShort() ),
        ( ( playerState, huffmanReader ) -> playerState.getDeltaAngles()[2] = huffmanReader.readShort() ),
        ( ( playerState, huffmanReader ) -> playerState.setTorsoTimer( huffmanReader.readBits( 12 ) ) ),
        ( ( playerState, huffmanReader ) -> playerState.getEventParms()[0] = (int) huffmanReader.readByte() ),
        ( ( playerState, huffmanReader ) -> playerState.getEventParms()[1] = (int) huffmanReader.readByte() ),
        ( ( playerState, huffmanReader ) -> playerState.setClientNum( (int) huffmanReader.readByte() ) ),
        ( ( playerState, huffmanReader ) -> playerState.setWeapon( huffmanReader.readBits( 5 ) ) ),
        ( ( playerState, huffmanReader ) -> playerState.getViewAngles()[2] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.getGrapplePoint()[0] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.getGrapplePoint()[1] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.getGrapplePoint()[2] = huffmanReader.readFloat() ),
        ( ( playerState, huffmanReader ) -> playerState.setJumppadEntity( huffmanReader.readBits( 10 ) ) ),
        ( ( playerState, huffmanReader ) -> playerState.setLoopSound( huffmanReader.readShort() ) )
    };

    public PlayerState loadPlayerState( HuffmanReader huffmanReader )
    {
        PlayerState playerState = new PlayerState();

        int count = huffmanReader.readByte();
        for( int playerStateFieldReaderIndex = 0; playerStateFieldReaderIndex < count; playerStateFieldReaderIndex++ )
        {
            if( fieldChanged( huffmanReader ) )
            {
                playerStateFieldReaders[playerStateFieldReaderIndex].read( playerState, huffmanReader );
            }
        }

        if( huffmanReader.readBit() == 1 )
        {
            if( huffmanReader.readBit() == 1 )
            {
                int statsBits = huffmanReader.readShort();
                for( int i = 0; i < 16; i++ )
                {
                    if( ( statsBits & ( 1 << i ) ) != 0 )
                    {
                        playerState.getStats()[i] = huffmanReader.readShort();
                    }
                }
            }

            if( huffmanReader.readBit() == 1 )
            {
                int persistentBits = huffmanReader.readShort();
                for( int i = 0; i < 16; i++ )
                {
                    if( ( persistentBits & ( 1 << i ) ) != 0 )
                    {
                        playerState.getPersistent()[i] = huffmanReader.readShort();
                    }
                }
            }

            if( huffmanReader.readBit() == 1 )
            {
                int ammoBits = huffmanReader.readShort();
                for( int i = 0; i < 16; i++ )
                {
                    if( ( ammoBits & ( 1 << i ) ) != 0 )
                    {
                        playerState.getAmmo()[i] = huffmanReader.readShort();
                    }
                }
            }

            if( huffmanReader.readBit() == 1 )
            {
                int powerupsBits = huffmanReader.readShort();
                for( int i = 0; i < 16; i++ )
                {
                    if( ( powerupsBits & ( 1 << i ) ) != 0 )
                    {
                        playerState.getPowerups()[i] = huffmanReader.readInt();
                    }
                }
            }
        }

        return playerState;
    }

    private boolean fieldChanged( HuffmanReader huffmanReader )
    {
        return huffmanReader.readBit() == 1;
    }

}
