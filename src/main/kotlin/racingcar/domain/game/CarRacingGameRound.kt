package racingcar.domain.game

import racingcar.domain.rule.MoveRule
import racingcar.domain.car.Car

class CarRacingGameRound(
    private val cars: List<Car>,
    private val moveRule: MoveRule,
) {
    fun run() {
        cars.forEach { car ->
            val moveDistance = moveRule.determineMoveDistance()
            car.move(moveDistance)
        }
    }
}
