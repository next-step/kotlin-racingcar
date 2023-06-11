package racingcar

import racingcar.model.Car
import racingcar.rule.RacingRule

class AlwaysMoveRule : RacingRule {
    override fun canMove(): Boolean = true

    override fun getWinners(cars: List<Car>): List<String> = cars.map { it.name }
}

class NeverMoveRule : RacingRule {
    override fun canMove(): Boolean = false

    override fun getWinners(cars: List<Car>): List<String> = cars.map { it.name }
}
