package carracing.view

import carracing.domain.Car
import carracing.domain.Cars

const val CAR_SYMBOL = "-"
const val GAME_RESULT_MESSAGE = "실행 결과"

object OutputView {

    fun printCar(cars: Cars) {
        for (element in cars) {
            gameRoundPrint(element)
        }
    }

    private fun gameRoundPrint(car: Car) {
        println("${car.getName()} :  ${CAR_SYMBOL.repeat(car.position)}")
    }

    fun lineChange() {
        println("")
    }

    fun printRacingCar() {
        println(GAME_RESULT_MESSAGE)
    }

    fun racingResult(winnerNames: String) {
        println("$winnerNames 가 최종 우승 하였습니다.")
    }
}
