package com.nextstep.racingcar

import com.nextstep.racingcar.domain.RacingGame
import com.nextstep.racingcar.domain.rules.NumberMoveRule
import com.nextstep.racingcar.domain.rules.RandomNumberGenerator
import com.nextstep.racingcar.view.CliInputView
import com.nextstep.racingcar.view.CliResultView

fun main() {
    val randomNumberGenerator = RandomNumberGenerator()
    val numberMoveRule = NumberMoveRule(randomNumberGenerator)
    val cliInputView = CliInputView()
    val cliResultView = CliResultView()
    val racingGame = RacingGame(numberMoveRule, cliInputView, cliResultView)
    racingGame.start()
}
