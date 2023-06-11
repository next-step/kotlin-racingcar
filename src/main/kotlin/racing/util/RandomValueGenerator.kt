package racing.util

import kotlin.random.Random

class RandomValueGenerator {

    fun getRandomValue(): Int {
        return Random.nextInt(0, 10)
    }
}
