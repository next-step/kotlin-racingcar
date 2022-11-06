package game.racingcar

import game.racingcar.move.MoveStrategy
import game.racingcar.move.RandomMoveStrategy

class RacingCars(
    numberOfCars: Int,
    moveStrategy: MoveStrategy = RandomMoveStrategy()
) {
    private val racingCars = (1..numberOfCars).map { RacingCar(moveStrategy) }

    fun moveAll(): List<Int> {
        return racingCars.onEach { it.move() }
            .run { this.map { it.location } }
    }
}
