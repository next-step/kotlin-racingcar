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
    }

    private fun generateRacingGame(): RacingGame {
        return try {
            val numberOfCar = InputView.inputNumberOfCar()
            val round = InputView.inputRound()
            RacingGame(Integer.valueOf(numberOfCar), Integer.valueOf(round))
        } catch (e: IllegalArgumentException) {
            println(String.format("게임을 생성하지 못하였습니다. 다시 입력해 주세요. %s", e.message))
            generateRacingGame()
        }
    }
}
