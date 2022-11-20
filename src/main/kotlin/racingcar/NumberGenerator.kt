package racingcar

interface NumberGenerator {
    fun rand(): Int
}

class RacingCarNumberGenerator : NumberGenerator {
    override fun rand(): Int {
        return (RAND_NUMBER_START_BOUND..RAND_NUMBER_END_BOUND).random()
    }

    companion object {
        private const val RAND_NUMBER_START_BOUND = 0
        private const val RAND_NUMBER_END_BOUND = 9
    }
}
