package racing.model.generator

import kotlin.random.Random

class RandomGenerator : Generator {
    private val rangeFrom = 1
    private val rangeUntil = 10
    private val random = Random(System.currentTimeMillis())
    override fun generate(): Int {
        return random.nextInt(rangeFrom, rangeUntil)
    }
}
