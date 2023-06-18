package racingame.view

import racingame.domain.RacingHistory

class OutputView {
    fun printResult() {
        println("\n실행 결과")
    }

    fun printPositionOfCars(histories: List<RacingHistory>) {
        histories.forEach { racingHistory ->
            racingHistory.history.forEach { car ->
                println("${car.name} : ${"-".repeat(car.position)}")
            }
            println()
        }
    }

    fun printWinner(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
