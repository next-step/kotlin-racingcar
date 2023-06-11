package racingcar.util

import kotlin.random.Random

class RandomGenerator : NumberGenerator {
    override fun generateNumber(): Int {
        return Random.nextInt(0, 10)
    }
}
