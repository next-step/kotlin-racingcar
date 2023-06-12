package racingCar.controller

import racingCar.view.InputView
import kotlin.random.Random

class RacingCarController {
    fun main() {
        val numberOfCar = InputView.getNumberOfTrial()
        val count = InputView.getNumberOfTrial()

        print("$numberOfCar, $count")
    }

    fun generateRandomNum(gt: Int, lt: Int): Int {
        return Random.nextInt(gt, lt)
    }

    fun IsMovingForward(value: Int, ref: Int): Boolean {
        return value >= ref
    }

}
