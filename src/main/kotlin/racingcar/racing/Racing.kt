package racingcar.racing

import racingcar.car.CarFactory
import racingcar.ui.ResultView

class Racing(carCount: Int, private val attemptCount: Int) {
    private val cars = CarFactory(carCount)

    fun start() {
        repeat(attemptCount) {
            cars.getResultCarList().forEach { car ->
                ResultView.printRacingResult(car.getLocation())
            }
            println()
        }
    }
}
