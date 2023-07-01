package racingcar.domain.numbergenerator

class RandomNumberGenerator : NumberGenerator {
    override fun get() = INT_RANGE.random()

    companion object {
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 9
        private val INT_RANGE = IntRange(MIN_RANGE, MAX_RANGE)
    }
}
