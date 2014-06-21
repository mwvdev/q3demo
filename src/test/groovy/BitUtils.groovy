class BitUtils {

    static combineBits( Integer[] bits ) {
        int result = 0

        for( bitOffset in 0..bits.length - 1 ) {
            result |= ( ( bits[bitOffset] & 1 ) << bitOffset )
        }

        return result
    }

}
