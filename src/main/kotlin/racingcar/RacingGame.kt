package racingcar

import racingcar.io.OutputView

object RacingGame {
    fun play(numberOfCars: Int, numberOfAttempts: Int, moveStrategy: MoveStrategy) {
        val participatingCars = loadCar(numberOfCars)
        start(participatingCars, numberOfAttempts, moveStrategy)
    }

    private fun loadCar(numberOfCars: Int): List<Car> = List(numberOfCars) { Car(it) }

    private fun start(cars: List<Car>, numberOfAttempts: Int, moveStrategy: MoveStrategy) {
        repeat(numberOfAttempts) {
            cars.forEach {
                it.move(moveStrategy)
                OutputView.showCarMoveResult(it.currentPosition)
            }
            OutputView.nextTurn()
        }
    }
}
