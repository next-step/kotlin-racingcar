package racingcar.strategy

class ManualStrategy(private val condition: Boolean) : ConditionGenerateStrategy {
    override fun generate(): Boolean {
        return condition
    }
}
