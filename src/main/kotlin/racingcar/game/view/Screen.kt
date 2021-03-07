package racingcar.game.view

import racingcar.game.domain.GameResult
import racingcar.game.vo.CarHistory
import racingcar.game.vo.GameRoundResult

object Screen {
    fun show(result: GameResult, winners: List<String>) {
        println("실행 결과")
        result.history.forEach { roundResult ->
            showRoundGame(roundResult)
        }
        printWinners(winners)
    }

    private fun printWinners(winners: List<String>) {
        print("${winners.joinToString(",")}가 최종 우승했습니다.")
    }

    private fun showRoundGame(roundResult: GameRoundResult) {
        roundResult.roundHistory.forEach { car ->
            printResult(car)
        }
        println()
    }

    private fun printResult(car: CarHistory) {
        println("${car.name} :" + "-".repeat(car.position))
    }
}
