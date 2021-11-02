package racingcar.racing

import racingcar.car.CarsFactory
import racingcar.ui.ResultView

class Racing(carsName: String, private val attemptCount: Int) {
    private val cars = CarsFactory.create(carsName)

    fun start() {
        repeat(attemptCount) {
            cars.startRound().forEach { car ->
                ResultView.printRacingResult(car)
            }
            println()
        }

        ResultView.printRacingWinner(cars.getWinner())
    }
}
