package racingcar.rule

import racingcar.util.RandomGenerator

class RacingRuleImpl(private val randomGenerator: RandomGenerator = RandomGenerator()) : RacingRule {
    override fun canMove(): Boolean {
        val randomValue = randomGenerator.value
        return randomValue >= LIMIT_VALUE
    }

    companion object {
        const val LIMIT_VALUE = 4
    }
}
