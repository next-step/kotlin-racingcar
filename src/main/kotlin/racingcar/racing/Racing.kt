package racingcar.racing

import racingcar.car.Cars
import racingcar.ui.ResultView

class Racing(carCount: Int, private val attemptCount: Int) {
    private val cars = Cars(carCount)

    fun start() {
        repeat(attemptCount) {
            cars.getRacingResult().forEach { car ->
                ResultView.printRacingResult(car.getLocation())
            }
            println()
        }
    }
}
