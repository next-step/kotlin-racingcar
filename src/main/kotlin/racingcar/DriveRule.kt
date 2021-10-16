package racingcar

import java.util.concurrent.ThreadLocalRandom

class DriveRule : DriveRangeStrategy {
    companion object {
        private const val FORWARD_NUMBER = 4

        fun random(): Int {
            return ThreadLocalRandom.current().nextInt(0, 9)
        }
    }

    override fun isForward(number: Int): Boolean {
        return number >= FORWARD_NUMBER
    }
}
