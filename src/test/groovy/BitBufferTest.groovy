import mwvdev.quake.buffer.BitBuffer
import mwvdev.quake.exceptions.LoaderException
import spock.lang.Specification

import java.nio.ByteBuffer

class BitBufferTest extends Specification {

    def "should return bits"() {
        List<Integer> inputBits = [ 1, 1, 1, 0, 1, 0, 0, 1 ]

        ByteBuffer byteBuffer = ByteBuffer.allocate( 1 )
        byteBuffer.put( (byte) BitUtils.combineBits( inputBits ) )
        byteBuffer.flip()
        BitBuffer bitBuffer = new BitBuffer( byteBuffer )

        when:
        List<Integer> outputBits = []
        for( i in 0..7 ) {
            outputBits.add( bitBuffer.read() )
        }

        then:
        outputBits == inputBits
    }

    def "should throw exception when reaching end of buffer"() {
        ByteBuffer byteBuffer = ByteBuffer.allocate( 1 )
        byteBuffer.put( (byte) 0 )

        BitBuffer bitBuffer = new BitBuffer( byteBuffer )

        when:
        for( i in 0..8 ) {
            bitBuffer.read()
        }

        then:
        thrown( LoaderException )
    }

}
