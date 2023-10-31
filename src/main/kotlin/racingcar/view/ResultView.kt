package racingcar.view

import racingcar.model.Car
import racingcar.model.RacingHistory

object ResultView {
    fun printInitial() {
        println("실행 결과")
    }

    fun printResult(racingHistories: List<RacingHistory>) {
        for (racingHistory in racingHistories) {
            racingHistory.cars.forEach { printResult(it.name, it.position) }
            println()
        }
    }

    fun printWinner(cars: List<Car>) {
        val names = cars.map { it.name }
        println("${names.joinToString(separator = ", ")}가 최종 우승했습니다.")
    }

    private fun printResult(name: String, count: Int) {
        print("$name: ")
        repeat(count) {
            print("-")
        }
        println()
    }
}
