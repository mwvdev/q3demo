Quake Live demo format loader
======
A basic Quake 3 demo loader for the dm_73 format. It supports loading data structures from the demo file and parsing them into POJOs.

Quake 3 uses a static Huffman tree for demo files. The static Huffman tree from [Quake Live Demo Tools](http://qldt.sourceforge.net/) is used by the [HuffmanDecoder](src/main/java/mwvdev/quake/huffman/HuffmanDecoder.java) class.

I used [vincasmiliunas/Quake-Live-Demo-Parser](https://github.com/vincasmiliunas/Quake-Live-Demo-Parser) as a reference, for inspiration and to verify that structures loaded were consistent, especially in regards to bit operations.