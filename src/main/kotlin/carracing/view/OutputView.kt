package carracing.view

import carracing.domain.Car
import carracing.domain.Cars
import carracing.domain.Racing

const val CAR_SYMBOL = "-"
const val GAME_RESULT_MESSAGE = "실행 결과"

object OutputView {

    private fun printCar(cars: Cars) {
        for (element in cars) {
            gameRoundPrint(element)
        }
    }

    private fun gameRoundPrint(car: Car) {
        println("${car.getName()} :  ${CAR_SYMBOL.repeat(car.position)}")
    }

    private fun lineChange() {
        println("")
    }

    fun printRacingCar(cars: Cars, attemptCount: Int) {
        println(GAME_RESULT_MESSAGE)
        for (round in 1..attemptCount) {
            printCar(Racing(cars).race())
            lineChange()
        }
    }

    fun racingResult(winnerNames: String) {
        println("$winnerNames 가 최종 우승 하였습니다.")
    }
}
