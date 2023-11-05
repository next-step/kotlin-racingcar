package racing

import kotlin.random.Random

object RandomGenerator {
    private val random = Random

    fun getRandomValue(): Int {
        return random.nextInt(0, 10)
    }
}
