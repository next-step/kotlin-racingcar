package racingcar.strategy

interface ConditionGenerateStrategy {
    fun generate(): Int

    companion object {
        const val MIN_CONDITION_VALUE = 0
        const val MAX_CONDITION_VALUE = 9
    }
}
