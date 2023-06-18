package racingame.view

import racingame.domain.RacingHistory

class OutputView {
    fun printResult() {
        println("\n실행 결과")
    }

    fun printRacingHistories(histories: List<RacingHistory>) {
        histories.forEach { racingHistory ->
            printPositionOfCars(racingHistory)
        }
    }

    private fun printPositionOfCars(racingHistory: RacingHistory) {
        racingHistory.history.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
