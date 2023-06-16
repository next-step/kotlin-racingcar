package racingcar.strategy

class RandomStrategy : ConditionGenerateStrategy {
    override fun generate(): Int {
        return (ConditionGenerateStrategy.MIN_CONDITION_VALUE..ConditionGenerateStrategy.MAX_CONDITION_VALUE).random()
    }
}
