package racingcar

import java.util.Random

class RandomNumber {
    companion object {
        private val RANDOM = Random()
        fun getBetweenZeroAnd(maxNumber: Int): Int {
            return RANDOM.nextInt(maxNumber)
        }
    }
}
