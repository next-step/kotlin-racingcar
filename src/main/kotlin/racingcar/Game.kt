package racingcar

import racingcar.ui.ResultView

class Game(private val configuration: GameConfiguration, movingStrategy: MovingStrategy) {
    val cars: List<Car> = (1..configuration.numberOfCars).map { Car(movingStrategy) }

    fun start() {
        repeat(configuration.numberOfAttempts) {
            proceedOneTurn()
            ResultView(
                cars.map { car ->
                    car.position
                }.toList()
            ).printResult()
        }
    }

    private fun proceedOneTurn() {
        cars.forEach { car ->
            car.attemptsMoveForward()
        }
    }
}
