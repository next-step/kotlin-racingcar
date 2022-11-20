package race

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator<Int> {
    override fun generate(): Int {
        val rand = Random(System.nanoTime())
        return (RANDOM_FIRST..RANDOM_LAST).random(rand)
    }

    companion object {
        private const val RANDOM_FIRST = 0
        private const val RANDOM_LAST = 9
    }
}
