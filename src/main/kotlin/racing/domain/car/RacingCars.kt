package racing.domain.car

import racing.domain.movement.MoveStrategy

class RacingCars(private val racingCars: List<RacingCar>) {
    fun race(tryCount: Int, moveStrategy: MoveStrategy) =
        (1..tryCount).map { _ -> racingCars.map { it.move(moveStrategy) } }
}
