package mwvdev.quake.huffman;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class HuffmanReader
{

    private HuffmanDecoder huffmanDecoder;

    public HuffmanReader( HuffmanDecoder huffmanDecoder )
    {
        this.huffmanDecoder = huffmanDecoder;
    }

    public int readBit()
    {
        return huffmanDecoder.getBitBuffer().read();
    }

    public int readBits( int bits )
    {
        int result = 0;

        int bitCount = bits & 7;
        if( bitCount > 0 )
        {
            for( int i = 0; i < bitCount; ++i )
            {
                result |= ( huffmanDecoder.getBitBuffer().read() << i );
            }
        }

        int byteCount = bits / 8;
        if( byteCount > 0 )
        {
            for( int i = 0; i < byteCount; i++ )
            {
                int bitOffset = i * 8 + bitCount;
                result |= ( huffmanDecoder.read() << ( bitOffset ) );
            }
        }

        return result;
    }

    public float readFloat()
    {
        if( huffmanDecoder.getBitBuffer().read() == 0 )
        {
            return readBits( 13 ) - 4096;
        }
        else
        {
            return java.lang.Float.intBitsToFloat( readInt() );
        }
    }

    public byte readByte()
    {
        int symbol = huffmanDecoder.read();

        return (byte) symbol;
    }

    public byte readSignedByte()
    {
        byte symbol = readByte();

        return (byte) ( symbol | ( 0xFFFFFF00 * ( ( symbol >> 7 ) & 1 ) ) );
    }

    public byte[] readBytes( int amount )
    {
        byte[] bytes = new byte[amount];

        for( int i = 0; i < amount; i++ )
        {
            bytes[i] = readByte();
        }

        return bytes;
    }

    public int readShort()
    {
        return readBits( 16 );
    }

    public int readSignedShort()
    {
        int result = readShort();
        return result | ( 0xFFFF0000 * ( ( result >> 15 ) & 1 ) );
    }

    public int readInt()
    {
        return readBits( 32 );
    }

    public String readString()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte nextByte = readByte();
        while( nextByte != 0 )
        {
            outputStream.write( nextByte );
            nextByte = (byte) huffmanDecoder.read();
        }

        return new String( outputStream.toByteArray(), StandardCharsets.UTF_8 );
    }

}
