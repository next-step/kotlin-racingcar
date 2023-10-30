package racingcar.domain.game

import racingcar.domain.car.Car
import racingcar.domain.rule.MoveRule

class CarMover(
    private val moveRule: MoveRule,
) {
    fun move(cars: List<Car>) {
        cars.forEach { car ->
            val moveDistance = moveRule.determineMoveDistance()
            car.move(moveDistance)
        }
    }
}
