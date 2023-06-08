package study.racinggame.race.mock

import kotlin.random.Random

class MockRandom(
    private val value: Int
) : Random() {
    override fun nextBits(bitCount: Int): Int {
        return 0
    }

    override fun nextInt(until: Int): Int {
        return value
    }
}
