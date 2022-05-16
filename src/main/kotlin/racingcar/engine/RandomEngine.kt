package racingcar.engine

import random.RandomNumberGenerator

class RandomEngine : Engine {

    override fun accelerate(): Distance {
        val random = RandomNumberGenerator.generate(RANDOM_FROM, RANDOM_TO)
        val distance = if (shouldMove(random)) 1 else 0

        return Distance(distance)
    }

    private fun shouldMove(randomNumber: Int): Boolean {
        return randomNumber >= MOVE_THRESHOLD
    }

    companion object {
        private const val RANDOM_FROM = 0
        private const val RANDOM_TO = 10
        private const val MOVE_THRESHOLD = 4
    }
}
