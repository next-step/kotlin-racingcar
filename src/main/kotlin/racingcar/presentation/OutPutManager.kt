package racingcar.presentation

import racingcar.domain.Car
import racingcar.domain.Cars

class OutPutManager {

    fun printCars(cars: List<Car>) {
        cars.forEach {
            println("${it.getName()} : ${"-".repeat(it.distance)}")
        }
        println()
    }

    fun printCars(cars: Cars) {
        cars.getCars().forEach {
            println("${it.getName()} : ${"-".repeat(it.distance)}")
        }
        println()
    }
    fun printWinner(winner: Cars) {
        println("${winner.getCars().map { it.getName() }.joinToString(",")} 가 최종 우승했습니다.")
    }

    fun printBeginResultMessage() {
        println(PRINT_BEGIN_RESULT_MESSAGE)
    }

    companion object {
        const val PRINT_BEGIN_RESULT_MESSAGE = "실행 결과"
    }
}
