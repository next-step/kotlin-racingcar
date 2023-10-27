package racing.model.generator

import kotlin.random.Random

class RandomGenerator : Generator {
    private val random = Random(System.currentTimeMillis())
    override fun generate(): Int {
        return random.nextInt(1, 10)
    }
}
