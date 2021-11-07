package racingcar.domain.racing

import racingcar.domain.car.Car
import racingcar.domain.car.CarsFactory

class Racing(carsName: String, private val attemptCount: Int) {
    private val cars = CarsFactory.create(carsName)

    fun start(showRacingResult: (Car) -> Unit, showRacingWinner: (List<String>) -> Unit) {
        repeat(attemptCount) {
            cars.startRound().forEach { car ->
                showRacingResult(car)
            }
            println()
        }

        showRacingWinner(cars.getWinner())
    }
}
