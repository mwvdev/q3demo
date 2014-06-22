package mwvdev.quake.loaders;

import mwvdev.quake.constants.QuakeConstants;
import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.DeltaEntityState;
import mwvdev.quake.models.EntityState;
import mwvdev.quake.models.RemovedEntityState;

public class EntityStateLoader
{

    private EntityFieldReader[] entityFieldReaders = {
        ( ( entityState, huffmanReader ) -> entityState.getPosition().setTime( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().getBase()[0] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().getBase()[1] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().getDelta()[0] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().getDelta()[1] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().getBase()[2] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().getBase()[1] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().getDelta()[2] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().getBase()[0] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().setGravity( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setEvent( readBits( huffmanReader, 10 ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngles2()[1] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.setEntityType( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setTorsoAnim( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setEventParm( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setLegsAnim( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setGroundEntityNum( readBits( huffmanReader, QuakeConstants.GENTITYNUM_BITS ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().setType( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setEntityFlags( readBits( huffmanReader, 19 ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setOtherEntityNum( readBits( huffmanReader, QuakeConstants.GENTITYNUM_BITS ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setWeapon( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setClientNum( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngles()[1] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getPosition().setDuration( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().setType( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getOrigin()[0] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getOrigin()[1] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getOrigin()[2] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.setSolid( readBits( huffmanReader, 24 ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setPowerups( readBits( huffmanReader, 16 ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setModelIndex( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setOtherEntityNum2( readBits( huffmanReader, QuakeConstants.GENTITYNUM_BITS ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setLoopSound( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setGeneric1( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getOrigin2()[2] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getOrigin2()[0] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getOrigin2()[1] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.setModelIndex2( (int) readByte( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngles()[0] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.setTime( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().setTime( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().setDuration( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().getBase()[2] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().getDelta()[0] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().getDelta()[1] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().getDelta()[2] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngle().setGravity( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setTime2( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngles()[2] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngles2()[0] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.getAngles2()[2] = readFloat( huffmanReader ) ),
        ( ( entityState, huffmanReader ) -> entityState.setConstantLight( readInt( huffmanReader ) ) ),
        ( ( entityState, huffmanReader ) -> entityState.setFrame( readBits( huffmanReader, 16 ) ) )
    };

    public EntityState loadEntityState( HuffmanReader huffmanReader, int entityNumber )
    {
        // Entity was removed
        if( huffmanReader.readBit() == 1 )
        {
            RemovedEntityState removedEntityState = new RemovedEntityState();
            removedEntityState.setNumber( entityNumber );

            return removedEntityState;
        }

        // Entity was unchanged
        DeltaEntityState entityState = new DeltaEntityState();
        entityState.setNumber( entityNumber );
        if( huffmanReader.readBit() == 0 )
        {
            return entityState;
        }

        int count = huffmanReader.readByte();
        for( int entityFieldReaderIndex = 0; entityFieldReaderIndex < count; entityFieldReaderIndex++ )
        {
            if( fieldChanged( huffmanReader ) )
            {
                entityFieldReaders[entityFieldReaderIndex].read( entityState, huffmanReader );
            }
        }

        return entityState;
    }

    private boolean fieldChanged( HuffmanReader huffmanReader )
    {
        return huffmanReader.readBit() == 1;
    }

    private int readBits( HuffmanReader huffmanReader, int bitCount )
    {
        int result;

        if( huffmanReader.readBit() == 0 )
        {
            result = 0;
        }
        else
        {
            result = huffmanReader.readBits( bitCount );
        }

        return result;
    }

    private float readFloat( HuffmanReader huffmanReader )
    {
        float result;

        if( huffmanReader.readBit() == 0 )
        {
            result = 0;
        }
        else
        {
            result = huffmanReader.readFloat();
        }

        return result;
    }

    private int readByte( HuffmanReader huffmanReader )
    {
        byte result;

        if( huffmanReader.readBit() == 0 )
        {
            result = 0;
        }
        else
        {
            result = huffmanReader.readByte();
        }

        return result;
    }

    private int readInt( HuffmanReader huffmanReader )
    {
        int result;

        if( huffmanReader.readBit() == 0 )
        {
            result = 0;
        }
        else
        {
            result = huffmanReader.readInt();
        }

        return result;
    }

}
