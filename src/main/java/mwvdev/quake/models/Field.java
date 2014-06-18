package mwvdev.quake.models;

public class Field
{

    private final int offset;
    private final int bits;

    public Field( int bits, int offset )
    {
        this.bits = bits;
        this.offset = offset;
    }

    public int getOffset()
    {
        return offset;
    }

    public int getBits()
    {
        return bits;
    }

}
