package racingcar

import kotlin.random.Random

class DriveRule : DriveRangeStrategy {
    companion object {
        private const val FORWARD_NUMBER = 4

        fun random(): Int {
            return Random.nextInt(9)
        }
    }

    override fun isForward(number: Int): Boolean {
        return number >= FORWARD_NUMBER
    }
}
