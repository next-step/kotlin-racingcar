package racingcar.util

import kotlin.random.Random

class RandomGenerator0To9: Generator {
    override val value: Int
        get() = Random.nextInt(10)
}
