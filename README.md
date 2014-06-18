Quake Live demo format loader
======
A basic Quake 3 demo loader for the dm_73 format. It is still a work in progress and quite a bit of work and testing is still required.

Quake 3 uses a static Huffman tree for demo files. The static Huffman tree from Quake Live Demo Tools (http://qldt.sourceforge.net/) is used the HuffmanDecoder class.

I used [vincasmiliunas/Quake-Live-Demo-Parser](https://github.com/vincasmiliunas/Quake-Live-Demo-Parser) for inspiration and to verify that structures loaded were consistent.