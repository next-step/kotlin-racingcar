package step3.racingcar.domain

class DefaultEngine : Engine {
    override fun generateCriterionValueToRace(): Int = (START_RANGE..END_RANGE).random()

    companion object {
        private const val START_RANGE = 0
        private const val END_RANGE = 9
    }
}
