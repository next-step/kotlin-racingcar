package racingcar.racing

import racingcar.car.Cars
import racingcar.ui.ResultView

class Racing(carsName: String, private val attemptCount: Int) {
    private val cars = Cars(carsName)

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
