package fixture

import kotlin.random.Random

class NextRandomFixture(
    private val fixValue: Int
) : Random() {
    override fun nextBits(bitCount: Int): Int = bitCount
    override fun nextInt(until: Int): Int = fixValue
}
