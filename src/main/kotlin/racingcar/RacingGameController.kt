package racingcar

import racingcar.io.OutputView
import racingcar.io.ParticipateCarName
import racingcar.strategy.MoveStrategy

object RacingGameController {
    private const val FIRST_TURN = 1

    fun play(nameOfCars: List<ParticipateCarName>, numberOfAttempts: Int, moveStrategy: MoveStrategy) {
        val participatingCars = loadCar(nameOfCars)
        start(participatingCars, numberOfAttempts, moveStrategy)
    }

    private fun loadCar(nameOfCars: List<ParticipateCarName>): List<Car> =
        nameOfCars.mapIndexed { index, participateCar -> Car(id = index, name = participateCar.name) }

    private fun start(cars: List<Car>, numberOfAttempts: Int, moveStrategy: MoveStrategy) {
        val carRecorder = CarRecorder()

        turn(FIRST_TURN, numberOfAttempts, carRecorder, cars, moveStrategy)

        pickWinners(carRecorder, numberOfAttempts)
    }

    private fun turn(
        turn: Int,
        finalTurn: Int,
        carRecorder: CarRecorder,
        cars: List<Car>,
        moveStrategy: MoveStrategy
    ): List<Car> {
        return if (turn > finalTurn) {
            cars
        } else {
            val movingCars = cars.map { it.move(moveStrategy) }
            OutputView.showMovingCarResult(movingCars)
            carRecorder.recording(turn, movingCars)

            turn(turn.inc(), finalTurn, carRecorder, movingCars, moveStrategy)
        }
    }

    private fun pickWinners(carRecorder: CarRecorder, finalTurn: Int) {
        val winners = carRecorder.findWinners(finalTurn)
        OutputView.showWinners(winners)
    }
}
