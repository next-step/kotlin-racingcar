package study

import org.junit.jupiter.api.Test

class RadixTest {
    @Test
    fun `radix test`() {
        (Character.MIN_RADIX..Character.MAX_RADIX).forEach { radix ->
            print("$radix : ${42.toString(radix)}")
        }
    }
}
