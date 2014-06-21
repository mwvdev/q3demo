

import mwvdev.quake.buffer.BitBuffer
import mwvdev.quake.huffman.HuffmanDecoder
import mwvdev.quake.huffman.HuffmanReader
import spock.lang.Specification

import java.nio.ByteBuffer

class HuffmanReaderTest extends Specification {

    def "readByte should work with specific sequence"() {
        Byte[] bytes = [ BitUtils.combineBits( [ 1, 1, 1, 0, 1, 0, 0, 1 ] as Integer[] ), 0 ]
        HuffmanReader huffmanReader = createHuffmanReader( bytes )

        expect:
        huffmanReader.readByte() == 100
    }

    def "readBit should work"() {
        Integer[] inputBits = [ 1, 1, 1, 0, 1, 0, 0, 1 ]
        HuffmanReader huffmanReader = createHuffmanReader( [ BitUtils.combineBits( inputBits ) ] as Byte[] )

        when:
        Integer[] outputBits = new Integer[8]
        for( i in 0..7 ) {
            outputBits[i] = huffmanReader.readBit()
        }

        then:
        outputBits == inputBits
    }

    def "should read short integers"() {
        Byte[] bytes = [ BitUtils.combineBits( [ 0, 1, 0, 1, 1, 1, 0, 1 ] as Integer[] ),
                         BitUtils.combineBits( [ 0, 1, 0, 0, 1, 0, 0, 0 ] as Integer[] ),
                         BitUtils.combineBits( [ 0, 1, 0, 0, 1, 0, 0, 0 ] as Integer[] ) ]
        HuffmanReader huffmanReader = createHuffmanReader( bytes )

        expect:
        huffmanReader.readShort() == 0
        huffmanReader.readShort() == 668
    }

    def "should read snapped floats"() {
        Byte[] bytes = [ BitUtils.combineBits( [ 0, 0, 0, 1, 0, 1, 1, 1 ] as Integer[] ),
                         BitUtils.combineBits( [ 1, 0, 0, 1, 1, 1, 0, 0 ] as Integer[] ) ]
        HuffmanReader huffmanReader = createHuffmanReader( bytes )

        expect:
        huffmanReader.readFloat() == 308.0
    }

    def "should read floats"() {
        Byte[] bytes = [ BitUtils.combineBits( [ 1, 1, 1, 1, 0, 0, 1, 1 ] as Integer[] ),
                         BitUtils.combineBits( [ 0, 1, 1, 1, 0, 1, 0, 1 ] as Integer[] ),
                         BitUtils.combineBits( [ 1, 1, 0, 1, 1, 1, 0, 1 ] as Integer[] ),
                         BitUtils.combineBits( [ 0, 0, 1, 1, 0, 0, 0, 0 ] as Integer[] ),
                         BitUtils.combineBits( [ 0, 1, 0, 0, 0, 0, 0, 0 ] as Integer[] ) ]
        HuffmanReader huffmanReader = createHuffmanReader( bytes )

        expect:
        huffmanReader.readFloat() == -179.9395751953125
    }

    def createHuffmanReader( Byte[] bytes ) {
        ByteBuffer byteBuffer = ByteBuffer.allocate( bytes.length )

        for( i in 0..bytes.length - 1 ) {
            byteBuffer.put( bytes[i] )
        }

        byteBuffer.flip()

        HuffmanDecoder huffmanDecoder = new HuffmanDecoder( new BitBuffer( byteBuffer ) )
        return new HuffmanReader( huffmanDecoder )
    }

}