package racingcar.view

import racingcar.domain.to.GameHistoryResponse
import racingcar.domain.to.GameWinnerResponse

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
            println("-".repeat(carPositions[round]))
        }
    }

    fun printWinner(gameWinnerResponse: GameWinnerResponse) {
        val winnerNames = gameWinnerResponse.to
        println("${winnerNames.joinToString(", ")}가 최종 우승했습니다.")
    }
}
