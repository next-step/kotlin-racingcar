package racingcar

import kotlin.random.Random

class DriveRule : DriveRangeStrategy {
    companion object {
        private const val FORWARD_NUMBER = 4
    }

    private fun random(): Int {
        return Random.nextInt(9)
    }

    override fun isForward(): Boolean {
        return random() >= FORWARD_NUMBER
    }
}
