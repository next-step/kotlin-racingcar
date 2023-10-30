package racing.model.generator

import kotlin.random.Random

class RandomGenerator : Generator {

    private val random = Random(System.currentTimeMillis())

    override fun generate(): Int {
        return random.nextInt(LOWER, UPPER)
    }

    companion object {
        private const val LOWER = 1
        private const val UPPER = 10
    }
}
