package racing.model.generator

import kotlin.random.Random

class RandomGenerator : Generator {
    private val random = Random(99)
    override fun generate(): Int {
        return random.nextInt(1, 9)
    }
}
