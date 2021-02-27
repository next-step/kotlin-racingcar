package racingcar.utils

class RandomUtils {
    companion object {
        fun getBetweenZeroAnd(maxNumber: Int): Int {
            return kotlin.random.Random.nextInt(maxNumber)
        }
    }
}
