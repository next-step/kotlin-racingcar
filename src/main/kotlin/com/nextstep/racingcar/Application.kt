package com.nextstep.racingcar

import com.nextstep.racingcar.domain.NumberMoveRule
import com.nextstep.racingcar.domain.RacingGame
import com.nextstep.racingcar.domain.RandomNumberGenerator
import com.nextstep.racingcar.view.CliInputView
import com.nextstep.racingcar.view.CliResultView

fun main() {
    val randomNumberGenerator = RandomNumberGenerator()
    val numberMoveRule = NumberMoveRule()
    val cliInputView = CliInputView()
    val cliResultView = CliResultView()
    val racingGame = RacingGame(randomNumberGenerator, numberMoveRule, cliInputView, cliResultView)
    racingGame.start()
}
