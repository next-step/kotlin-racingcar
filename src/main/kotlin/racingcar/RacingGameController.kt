package racingcar

import racingcar.io.OutputView
import racingcar.io.ParticipateCarName

object RacingGameController {
    fun play(nameOfCars: List<ParticipateCarName>, numberOfAttempts: Int, moveStrategy: MoveStrategy) {
        val participatingCars = loadCar(nameOfCars)
        start(participatingCars, numberOfAttempts, moveStrategy)
    }

    private fun loadCar(nameOfCars: List<ParticipateCarName>): List<Car> =
        nameOfCars.mapIndexed { index, participateCar -> Car(id = index, name = participateCar.name) }

    private fun start(cars: List<Car>, numberOfAttempts: Int, moveStrategy: MoveStrategy) {
        repeat(numberOfAttempts) {
            cars.forEach {
                val movingCar = it.move(moveStrategy)
                OutputView.showMovingCarResult(movingCar)
            }
            OutputView.nextTurn()
        }
    }
}
