package racingcar.domain.rule

import racingcar.domain.RandomGenerator
import racingcar.domain.model.Car

class RacingRuleImpl(private val randomGenerator: RandomGenerator = RandomGenerator()) : RacingRule {
    override fun canMove(): Boolean {
        val randomValue = randomGenerator.value
        return randomValue >= LIMIT_VALUE
    }

    override fun getWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    companion object {
        const val LIMIT_VALUE = 4
    }
}
