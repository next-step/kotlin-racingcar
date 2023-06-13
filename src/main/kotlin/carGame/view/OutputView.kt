package carGame.view

import carGame.domain.Car
import carGame.domain.Cars

object OutputView {
    fun printHistory(history: List<Cars>) {
        println("실행 결과")
        for (cars in history) {
            printRoundHistory(cars)
        }
    }

    private fun printRoundHistory(cars: Cars) {
        for (car in cars.cars) {
            println("${car.name.value}: ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinner(winners: List<Car>) {
        println("${winners.joinToString { it.name.value }}가 최종 우승했습니다.")
    }
}
