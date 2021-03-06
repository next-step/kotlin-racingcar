package racingcar.game.ui

import racingcar.game.domain.Car
import racingcar.game.vo.GameResult
import racingcar.game.vo.GameRoundResult

object Screen {
    fun show(result: GameResult) {
        result.history.forEach { roundResult ->
            showRoundGame(roundResult)
        }
    }

    private fun showRoundGame(roundResult: GameRoundResult) {
        roundResult.roundHistory.forEach { car ->
            printResult(car)
        }
    }

    private fun printResult(car: Car) {
        println("${car.name} :" + "-".repeat(car.position))
    }
}
