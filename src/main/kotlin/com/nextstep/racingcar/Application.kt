package com.nextstep.racingcar

import com.nextstep.racingcar.domain.RacingGame
import com.nextstep.racingcar.domain.gamerules.NumberMoveRule
import com.nextstep.racingcar.domain.gamerules.RandomNumberGenerator
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
