package racingcar.view

import racingcar.domain.CarPositionDto
import racingcar.domain.Cars

class ResultView(private val cars: Cars) {

    fun print() {
        println("실행 결과")
        printEachTurn()
        printWinner()
    }

    private fun attemptCount() = cars[0].history.size

    private fun printEachTurn() {
        for (attempt in 1..attemptCount()) {
            cars.results(attempt).forEach { printCar(it) }
            println()
        }
    }

    private fun printCar(carPosition: CarPositionDto) {
        print("${carPosition.name} : ")
        println("-".repeat(carPosition.position))
    }

    private fun printWinner() {
        val winners = cars.winners()
        println("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }
}
