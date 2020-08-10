package com.nextstep.racingcar

import com.nextstep.racingcar.domain.RacingGame
import com.nextstep.racingcar.view.InputView
import com.nextstep.racingcar.view.OutputView

object RacingCarApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        val racingGame = generateRacingGame()
        OutputView.showResult()

        for (i in 1..racingGame.round) {
            racingGame.runRound()
            OutputView.showStatus(racingGame.cars)
        }

        val winners = racingGame.findWinners()
        OutputView.showWinner(winners)
    }

    private tailrec fun generateRacingGame(): RacingGame {
        val carNames = InputView.inputCarNames()
        val round = InputView.inputRound().toIntOrNull()
        return if (carNames.isBlank() || RacingGame.isInvalidRound(round)) {
            OutputView.inputError("입력값이 잘못되었습니다. 다시한번 확인해주세요.")
            generateRacingGame()
        } else {
            createGame(carNames, round)
        }
    }

    private fun createGame(carNames: String, round: Int?): RacingGame {
        return try {
            RacingGame(carNames, round)
        } catch (e: Exception) {
            OutputView.inputError(e.message)
            generateRacingGame()
        }
    }
}
