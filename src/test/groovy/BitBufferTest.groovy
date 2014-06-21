import mwvdev.quake.buffer.BitBuffer
import mwvdev.quake.exceptions.LoaderException
import spock.lang.Specification

import java.nio.ByteBuffer

class BitBufferTest extends Specification {

    def "should return bits"() {
        Integer[] inputBits = [ 1, 1, 1, 0, 1, 0, 0, 1 ]
        BitBuffer bitBuffer = createBitBuffer( [ BitUtils.combineBits( inputBits ) ] as Byte[] )

        when:
        Integer[] outputBits = new Integer[8]
        for( i in 0..7 ) {
            outputBits[i] = bitBuffer.read()
        }

        then:
        outputBits == inputBits
    }

    def "should throw exception when reaching end of buffer"() {
        BitBuffer bitBuffer = createBitBuffer( [ 0 ] as Byte[] )

        when:
        for( i in 0..8 ) {
            bitBuffer.read()
        }

        then:
        thrown( LoaderException )
    }

    def createBitBuffer( Byte[] bytes ) {
        ByteBuffer byteBuffer = ByteBuffer.allocate( bytes.length )

        for( i in 0..bytes.length - 1 ) {
            byteBuffer.put( bytes[i] )
        }

        byteBuffer.flip()

        return new BitBuffer( byteBuffer )
    }

}
