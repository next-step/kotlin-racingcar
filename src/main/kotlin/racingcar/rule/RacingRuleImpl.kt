package racingcar.rule

import racingcar.util.Generator

class RacingRuleImpl(private val randomGenerator: Generator) : RacingRule {
    override fun canMove(): Boolean {
        val randomValue = randomGenerator.value
        return randomValue >= LIMIT_VALUE
    }

    companion object {
        const val LIMIT_VALUE = 4
    }
}
