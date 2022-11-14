package race

import java.util.concurrent.ThreadLocalRandom

class RandomGeneratorNumber : RandomGenerator<Int> {
    private val random = ThreadLocalRandom.current()
    override fun generate(): Int {
        return random.nextInt(RANDOM_LAST - RANDOM_FIRST) + RANDOM_FIRST
    }

    companion object {
        private const val RANDOM_FIRST = 0
        private const val RANDOM_LAST = 9
    }
}
