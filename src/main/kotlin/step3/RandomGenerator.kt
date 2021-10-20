package step3

import java.util.Random

object RandomGenerator {
    private const val FIXED_BOUND = 10
    private val randomGenerator = Random()
    fun getRandomValue(bound: Int = FIXED_BOUND) = randomGenerator.nextInt(bound)
}
