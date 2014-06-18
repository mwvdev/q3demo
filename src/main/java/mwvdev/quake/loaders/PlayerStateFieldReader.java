package mwvdev.quake.loaders;

import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.PlayerState;

public interface PlayerStateFieldReader
{

    void read( PlayerState playerState, HuffmanReader huffmanReader );

}
