package racingcar.utils

class RandomGenerator {
    companion object {
        fun generateRandomNum(begin: Int, end: Int): Int {
            return (begin..end).random()
        }
    }
}
