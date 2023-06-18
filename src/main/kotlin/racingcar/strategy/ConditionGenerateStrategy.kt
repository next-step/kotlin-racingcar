package racingcar.strategy

interface ConditionGenerateStrategy {
    fun generate(): Boolean

    companion object {
        const val THRESHOLD = 4
        const val MIN_CONDITION_VALUE = 0
        const val MAX_CONDITION_VALUE = 9
    }
}
