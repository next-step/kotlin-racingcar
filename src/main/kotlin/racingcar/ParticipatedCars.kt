package racingcar

import racingcar.io.OutputView
import racingcar.strategy.MoveStrategy

class ParticipatedCars(
    private val moveStrategy: MoveStrategy
) {
    fun turn(
        turn: Int,
        finalTurn: Int,
        cars: List<Car>
    ): List<Car> {
        return if (turn > finalTurn) {
            cars
        } else {
            val movedCars = cars.map { it.move(moveStrategy) }
            OutputView.showMovingCarResult(movedCars)
            return turn(turn.inc(), finalTurn, movedCars)
        }
    }
}
