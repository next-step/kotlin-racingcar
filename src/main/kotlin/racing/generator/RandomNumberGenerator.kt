package racing.generator

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generate(number: Int): Int {
        return Random.nextInt(number)
    }
}
