class BitUtils {

    static combineBits( List<Integer> bits ) {
        int result = 0

        for( i in 0..bits.size - 1 ) {
            result |= ( ( bits.get( i ) & 1 ) << i )
        }

        return result
    }

}
