

import mwvdev.quake.buffer.BitBuffer
import mwvdev.quake.exceptions.HuffmanException
import mwvdev.quake.huffman.HuffmanDecoder
import mwvdev.quake.huffman.HuffmanReader
import spock.lang.Specification

import java.nio.ByteBuffer

class HuffmanReaderTest extends Specification {

    def "should work with specific sequence"() {
        ByteBuffer byteBuffer = ByteBuffer.allocate( 2 )
        byteBuffer.put( (byte) BitUtils.combineBits( [ 1, 1, 1, 0, 1, 0, 0, 1 ] ) )
        byteBuffer.put( (byte) 0 )
        byteBuffer.flip()

        HuffmanDecoder huffmanDecoder = new HuffmanDecoder( new BitBuffer( byteBuffer ) )
        HuffmanReader huffmanReader = new HuffmanReader( huffmanDecoder )

        expect:
        huffmanReader.readByte() == 100
    }

}
