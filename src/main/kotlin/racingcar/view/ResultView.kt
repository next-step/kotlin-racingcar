package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

class ResultView(private val cars: Cars) {

    fun print() {
        println("실행 결과")
        printEachTurn()
        printWinner()
    }

    private fun attemptCount() = cars[0].history.size

    private fun printEachTurn() {
        for (i in 1..attemptCount()) {
            cars.forEach { printCar(it, i) }
            println()
        }
    }

    private fun printCar(car: Car, attempt: Int) {
        print("${car.name} : ")
        println("-".repeat(car.currentPosition(attempt)))
    }

    private fun printWinner() {
        val winners = cars.winners(attemptCount())
        println("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }
}
