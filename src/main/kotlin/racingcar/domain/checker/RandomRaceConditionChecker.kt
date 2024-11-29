package racingcar.domain.checker

class RandomRaceConditionChecker : RaceConditionChecker {
    override fun isAdvancePossible(): Boolean = RANDOM_NUMBER_RANGE.random() >= MINIMUM_ADVANCE_NUMBER

    companion object {
        private const val MINIMUM_ADVANCE_NUMBER = 4
        private const val MINIMUM_RANDOM_NUMBER = 0
        private const val MAXIMUM_RANDOM_NUMBER = 9

        private val RANDOM_NUMBER_RANGE = MINIMUM_RANDOM_NUMBER..MAXIMUM_RANDOM_NUMBER
    }
}
