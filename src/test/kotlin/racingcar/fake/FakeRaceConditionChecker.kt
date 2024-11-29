package racingcar.fake

import racingcar.domain.checker.RaceConditionChecker

class FakeRaceConditionChecker(
    private val number: Int,
) : RaceConditionChecker {
    override fun isAdvancePossible(): Boolean = number >= MINIMUM_ADVANCE_NUMBER

    companion object {
        private const val MINIMUM_ADVANCE_NUMBER = 4
    }
}
