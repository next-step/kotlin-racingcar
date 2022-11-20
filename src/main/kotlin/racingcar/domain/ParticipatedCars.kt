package racingcar.domain

import racingcar.domain.strategy.MoveStrategy

class ParticipatedCars(
    private val moveStrategy: MoveStrategy
) {
    fun turn(
        turn: Int,
        finalTurn: Int,
        cars: List<Car>,
        carResult: (List<Car>) -> Unit,
    ): List<Car> {
        return if (turn > finalTurn) {
            cars
        } else {
            val movedCars: List<Car> = cars.map { it.move(moveStrategy) }
            carResult(movedCars)
            return turn(turn.inc(), finalTurn, movedCars, carResult)
        }
    }
}
