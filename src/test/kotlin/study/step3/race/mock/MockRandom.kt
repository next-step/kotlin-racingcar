package study.step3.race.mock

import kotlin.random.Random

class MockRandom(
    private val value: Int
) : Random() {
    override fun nextBits(bitCount: Int): Int {
        TODO("Not yet implemented")
    }

    override fun nextInt(until: Int): Int {
        return value
    }
}
