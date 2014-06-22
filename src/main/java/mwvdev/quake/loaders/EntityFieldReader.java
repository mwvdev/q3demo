package mwvdev.quake.loaders;

import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.DeltaEntityState;

public interface EntityFieldReader
{

    void read( DeltaEntityState entityState, HuffmanReader huffmanReader );

}
