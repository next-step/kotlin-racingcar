package racingcar.game.view

import racingcar.game.domain.GameResult
import racingcar.game.vo.CarHistory
import racingcar.game.vo.GameRoundResult

object Screen {
    fun show(result: GameResult) {
        println("실행 결과")
        result.history.forEach { roundResult ->
            showRoundGame(roundResult)
        }
        printWinners(result)
    }

    private fun printWinners(result: GameResult) {
        val lastRoundHistory: List<CarHistory> = result.history.last().roundHistory
        val maxPosition: Int? = lastRoundHistory.maxOfOrNull { it.position }
        val maxPositionCars: List<String> = lastRoundHistory.filter {
            it.position == maxPosition
        }.map { it.name }

        val winners = maxPositionCars.joinToString(",")
        print("${winners}가 최종 우승했습니다.")
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
