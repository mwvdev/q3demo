package mwvdev.quake.loaders;

import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.EntityState;

public interface EntityFieldReader
{

    void read( EntityState entityState, HuffmanReader huffmanReader );

}
