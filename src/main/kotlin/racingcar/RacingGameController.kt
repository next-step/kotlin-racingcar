package racingcar

import racingcar.io.OutputView

object RacingGameController {
    fun play(nameOfCars: List<String>, numberOfAttempts: Int, moveStrategy: MoveStrategy) {
        val participatingCars = loadCar(nameOfCars)
        start(participatingCars, numberOfAttempts, moveStrategy)
    }

    private fun loadCar(nameOfCars: List<String>): List<Car> =
        nameOfCars.mapIndexed { index, name -> Car(id = index, name = name) }

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
