package racingcar.strategy

class RandomStrategy : ConditionGenerateStrategy {
    override fun generate(): Boolean {
        return (ConditionGenerateStrategy.MIN_CONDITION_VALUE..ConditionGenerateStrategy.MAX_CONDITION_VALUE).random() >= ConditionGenerateStrategy.THRESHOLD
    }
}
