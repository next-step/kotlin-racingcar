package step3.domain.random

import java.util.Random

class RandomGenerator {
    private val random = Random()

    fun getIntRandom(): Int = random.nextInt(MAX_RANDOM)

    companion object {
        private const val MAX_RANDOM = 10
    }
}
