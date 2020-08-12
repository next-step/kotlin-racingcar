package com.nextstep.racingcar

import com.nextstep.racingcar.domain.RacingGame
import com.nextstep.racingcar.view.InputView
import com.nextstep.racingcar.view.OutputView

object RacingCarApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        val carNames = getCarNames()
        val round = getRound()
        try {
            val racingGame = RacingGame.createGame(carNames, round)
            OutputView.showResult()

            repeat(racingGame.round) {
                racingGame.runRound()
                OutputView.showStatus(racingGame.cars)
            }

            val winners = racingGame.findWinners()
            OutputView.showWinner(winners)
        } catch (e: Exception) {
            OutputView.inputError(e.message)
        }
    }

    private tailrec fun getCarNames(): String {
        val carNames = InputView.inputCarNames()
        return if (carNames.isBlank()) {
            OutputView.inputError("자동차 이름은 공백일 수 없습니다.")
            getCarNames()
        } else {
            carNames
        }
    }

    private tailrec fun getRound(): Int {
        val round = InputView.inputRound().toIntOrNull()
        return if (RacingGame.isInvalidRound(round)) {
            OutputView.inputError("라운드는 0보다 큰 숫자여야합니다.")
            getRound()
        } else {
            round ?: throw IllegalArgumentException("round가 잘못됨.")
        }
    }
}
