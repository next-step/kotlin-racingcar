package racingcar.domain.rule

import racingcar.domain.model.Car

interface RacingRule {
    fun canMove(): Boolean

    fun getWinners(cars: List<Car>): List<String>
}
