package racingcar.racing

import racingcar.car.CarFactory
import racingcar.constant.Constant
import racingcar.ui.ResultView

class Racing(carCount: Int, private val attemptCount: Int) {
    private val cars = CarFactory.create(carCount)

    fun start() {
        for (i in Constant.START..attemptCount) {
            cars.getResultCarList().forEach { car ->
                ResultView.printRacingResult(car.getLocation())
            }
            println()
        }
    }
}
