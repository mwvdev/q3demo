

import mwvdev.quake.buffer.BitBuffer
import mwvdev.quake.huffman.HuffmanDecoder
import mwvdev.quake.huffman.HuffmanReader
import spock.lang.Specification

import java.nio.ByteBuffer

class HuffmanReaderTest extends Specification {

    def "should work with specific sequence"() {
        ByteBuffer byteBuffer = ByteBuffer.allocate( 2 )

        byte b1 = 0
        b1 |= ( 1 << 0 )
        b1 |= ( 1 << 1 )
        b1 |= ( 1 << 2 )
        b1 |= ( 0 << 3 )
        b1 |= ( 1 << 4 )
        b1 |= ( 0 << 5 )
        b1 |= ( 0 << 6 )
        b1 |= ( 1 << 7 )

        byte b2 = 0
        byteBuffer.put( b1 )
        byteBuffer.put( b2 )

        byteBuffer.flip()

        HuffmanDecoder huffmanDecoder = new HuffmanDecoder( new BitBuffer( byteBuffer ) )
        HuffmanReader huffmanReader = new HuffmanReader( huffmanDecoder )

        expect:
        huffmanReader.readByte() == 100
    }

}
