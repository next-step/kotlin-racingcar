package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

class ResultView {

    fun printTitle() {
        println("실행 결과")
    }

    fun printEachTurn(cars: Cars) {
        cars.forEach { printCar(it) }
        println()
    }

    fun printWinner(cars: Cars) {
        val winners = cars.winners()
        println("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    private fun printCar(car: Car) {
        print("${car.name} : ")
        println("-".repeat(car.movedDistance()))
    }
}
