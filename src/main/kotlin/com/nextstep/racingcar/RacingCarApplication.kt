package com.nextstep.racingcar

import com.nextstep.racingcar.domain.RacingGame
import com.nextstep.racingcar.view.InputView
import com.nextstep.racingcar.view.OutputView

object RacingCarApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        val racingGame = generateRacingGame()
        OutputView.showResult()
        racingGame.runGame()
        racingGame.findWinners()
    }

    private tailrec fun generateRacingGame(): RacingGame {
        val carNames = InputView.inputCarNames()
        val round = InputView.inputRound().toIntOrNull()
        return if (carNames.isBlank() || RacingGame.isInvalidRound(round)) {
            println("입력값이 잘못되었습니다. 다시한번 확인해주세요.")
            generateRacingGame()
        } else {
            RacingGame(carNames, round)
        }
    }
}
