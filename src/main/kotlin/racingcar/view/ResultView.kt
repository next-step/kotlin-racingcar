package racingcar.view

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

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
        println("${car.name} : ${"-".repeat(car.movedDistance())}")
    }
}
