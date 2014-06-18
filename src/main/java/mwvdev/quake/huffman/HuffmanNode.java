package mwvdev.quake.huffman;

public class HuffmanNode
{

    private int symbol;

    private HuffmanNode left;
    private HuffmanNode right;

    public int getSymbol()
    {
        return symbol;
    }

    public void setSymbol( int symbol )
    {
        this.symbol = symbol;
    }

    public HuffmanNode getLeft()
    {
        return left;
    }

    public void setLeft( HuffmanNode left )
    {
        this.left = left;
    }

    public HuffmanNode getRight()
    {
        return right;
    }

    public void setRight( HuffmanNode right )
    {
        this.right = right;
    }

}
