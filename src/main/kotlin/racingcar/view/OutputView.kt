package racingcar.view

import racingcar.domain.to.GameHistoryResponse

class OutputView {
    fun printResult(
        inputRoundCount: Int,
        gameHistoryResponse: GameHistoryResponse,
    ) {
        println("실행 결과")
        for (round in 1..inputRoundCount) {
            printRoundRecord(gameHistoryResponse, round)
            println()
        }
    }

    private fun printRoundRecord(
        gameHistoryResponse: GameHistoryResponse,
        round: Int,
    ) {
        for ((carName, carPositions) in gameHistoryResponse.to) {
            print("$carName : ")
            println("-".repeat(carPositions[round - 1]))
        }
    }

    fun printWinner(winner: List<String>) {
        println("${winner.joinToString(", ")}가 최종 우승했습니다.")
    }
}
