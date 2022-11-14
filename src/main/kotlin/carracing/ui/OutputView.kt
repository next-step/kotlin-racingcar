package carracing.ui

import carracing.domain.Car
import carracing.domain.Cars
import carracing.domain.Racing

const val CAR_SYMBOL = "-"
const val GAME_RESULT_MESSAGE = "실행 결과"

object OutputView {

    fun gameRoundPrint(position: Int) {
        println(CAR_SYMBOL.repeat(position))
    }

    fun racingResult(carCount: Int, attemptCount: Int) {
        println(GAME_RESULT_MESSAGE)
        val cars = Cars((1..carCount).map { Car() })
        Racing(cars, attemptCount).race()
    }

    fun lineChange() {
        println("")
    }
}
