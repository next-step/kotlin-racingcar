package carracing.ui

import carracing.domain.Car
import carracing.domain.Cars
import carracing.domain.Racing

const val CAR_SYMBOL = "-"
const val GAME_RESULT_MESSAGE = "실행 결과"

object OutputView {

    private fun printCar(cars: Cars) {
        for (element in cars) {
            gameRoundPrint(element.position)
        }
    }

    private fun gameRoundPrint(position: Int) {
        println(CAR_SYMBOL.repeat(position))
    }

    private fun lineChange() {
        println("")
    }

    fun racingResult(carCount: Int, attemptCount: Int) {
        println(GAME_RESULT_MESSAGE)
        val cars = Cars((1..carCount).map { Car() })

        for (round in 1..attemptCount) {
            printCar(Racing(cars).race())
            lineChange()
        }
    }
}
