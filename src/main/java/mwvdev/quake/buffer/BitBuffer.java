package mwvdev.quake.buffer;

import mwvdev.quake.exceptions.LoaderException;

import java.nio.ByteBuffer;

public class BitBuffer
{

    private int position = 0;

    private ByteBuffer byteBuffer;

    public BitBuffer( ByteBuffer byteBuffer )
    {
        this.byteBuffer = byteBuffer;
    }

    public int read()
    {
        if( byteBuffer.limit() * 8 < position )
        {
            throw new LoaderException( "Unexpected end of file reached. This could indicate a corrupted demo." );
        }

        int bit_offset = position & 7;
        int byte_offset = position / 8;

        int result = byteBuffer.get( byte_offset ) >> bit_offset;

        position++;

        return result & 1;
    }

}
