package racingcar.racing

import racingcar.constant.Constant
import racingcar.ui.ResultView
import racingcar.util.Cars

class Racing(carCount: Int, private val attemptCount: Int) {
    private val cars = Cars.create(carCount)

    fun start() {
        for (i in Constant.START..attemptCount) {
            cars.getResultCarList().forEach {
                ResultView.printRacingResult(it.distance)
            }
            println()
        }
    }
}
