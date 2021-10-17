package racingcar

import kotlin.random.Random

class DriveRule : DriveRangeStrategy {
    companion object {
        private const val NUMBER_RANDOM_MAX = 9
        const val FORWARD_NUMBER = 4
    }

    fun random(): Int {
        return Random.nextInt(NUMBER_RANDOM_MAX)
    }

    override fun isForward(): Boolean {
        return random() >= FORWARD_NUMBER
    }
}
