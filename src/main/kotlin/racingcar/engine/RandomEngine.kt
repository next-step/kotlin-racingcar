package racingcar.engine

import random.RandomNumberGenerator

class RandomEngine : Engine {

    override fun accelerate(): Distance {
        val random = RandomNumberGenerator.generate(RANDOM_FROM, RANDOM_TO)

        return Distance(if (random >= MOVE_THRESHOLD) 1 else 0)
    }

    companion object {
        private const val RANDOM_FROM = 0
        private const val RANDOM_TO = 10
        private const val MOVE_THRESHOLD = 4
    }
}
