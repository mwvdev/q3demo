package mwvdev.quake.loaders;

import mwvdev.quake.huffman.HuffmanReader;

public abstract class StateLoader
{

    protected int readBits( HuffmanReader huffmanReader, int bitCount )
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

    protected float readFloat( HuffmanReader huffmanReader )
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

    protected int readByte( HuffmanReader huffmanReader )
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

    protected int readInt( HuffmanReader huffmanReader )
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
