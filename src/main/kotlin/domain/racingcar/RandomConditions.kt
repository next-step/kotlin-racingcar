package domain.racingcar

import kotlin.random.Random

class RandomConditions : Conditions {
    override fun makeCondition(): Int {
        return Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }

    companion object {
        private const val MIN_RANDOM_NUMBER = 1
        private const val MAX_RANDOM_NUMBER = 10
    }
}
