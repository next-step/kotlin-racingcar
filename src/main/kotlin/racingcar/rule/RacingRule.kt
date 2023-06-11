package racingcar.rule

import racingcar.model.Car

interface RacingRule {
    fun canMove(): Boolean

    fun getWinners(cars: List<Car>): List<String>
}
