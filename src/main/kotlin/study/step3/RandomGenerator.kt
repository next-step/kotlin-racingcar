package study.step3

class RandomGenerator {

    fun generateRandomValue() = (MIN_VALUE..MAX_VALUE).random()

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 9
    }
}
