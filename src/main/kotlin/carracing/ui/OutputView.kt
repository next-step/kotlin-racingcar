package carracing.ui

import carracing.domain.Car
import carracing.domain.Cars
import carracing.domain.Name
import carracing.domain.Racing
import carracing.domain.Winners

const val CAR_SYMBOL = "-"
const val GAME_RESULT_MESSAGE = "실행 결과"
const val CAR_NAME_DELIMITER = ","

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

    fun racingResult(carNames: String, attemptCount: Int) {
        println(GAME_RESULT_MESSAGE)

        val cars = Cars(carNames.split(CAR_NAME_DELIMITER).map { Car(Name(it)) })

        for (round in 1..attemptCount) {
            printCar(Racing(cars).race())
            lineChange()
        }

        val winners  = Winners(cars).getWinners().joinToString(",") {
            it.getName()
        }

        println("$winners 가 최종 우승 하였습니다.")
    }
}
