package racingcar.strategy

class ManualStrategy(private val condition: Int) : ConditionGenerateStrategy {
    override fun generate(): Int {
        return condition
    }
}