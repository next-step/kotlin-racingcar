package racing.model.generator

import kotlin.random.Random

class RandomGenerator {
    private val random = Random(99)
    fun generate(): Int {
        return random.nextInt(1, 9)
    }
}
