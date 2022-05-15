package racingcar.engine

import random.RandomNumberGenerator

const val RANDOM_FROM = 0
const val RANDOM_TO = 10
const val MOVE_THRESHOLD = 4

class RandomEngine {

    fun accelerate(): Distance {
        val random = RandomNumberGenerator.generate(RANDOM_FROM, RANDOM_TO)

        return Distance(if (random >= MOVE_THRESHOLD) 1 else 0)
    }
}
