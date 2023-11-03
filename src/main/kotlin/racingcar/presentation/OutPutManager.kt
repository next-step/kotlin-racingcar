package racingcar.presentation

import racingcar.domain.Car
import racingcar.domain.Cars

class OutPutManager {

    fun printCars(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.distance)}")
        }
        println()
    }

    fun printCars(cars: Cars) {
        cars.cars.forEach {
            println("${it.name} : ${"-".repeat(it.distance)}")
        }
        println()
    }

    fun printWinner(winner: String) {

        println("$winner 가 최종 우승했습니다.")
    }

    fun printBeginResultMessage() {
        println(PRINT_BEGIN_RESULT_MESSAGE)
    }

    companion object {
        const val PRINT_BEGIN_RESULT_MESSAGE = "실행 결과"
    }
}
