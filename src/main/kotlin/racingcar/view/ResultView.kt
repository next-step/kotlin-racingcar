package racingcar.view

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

    private fun printResult(name: String, count: Int) {
        print("$name: ")
        repeat(count) {
            print("-")
        }
        println()
    }
}
