package racingcar

import kotlin.random.Random

class DriveRule : DriveRangeStrategy {
    companion object {
        const val FORWARD_NUMBER = 4
    }

    fun random(): Int {
        return Random.nextInt(9)
    }

    override fun isForward(): Boolean {
        return random() >= FORWARD_NUMBER
    }
}
