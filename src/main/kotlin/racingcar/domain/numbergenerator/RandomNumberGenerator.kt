package racingcar.domain.numbergenerator

class RandomNumberGenerator : NumberGenerator {
    override fun get(): Int {
        return (MIN_RANGE..MAX_RANGE).random()
    }

    companion object {
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 9
    }
}
