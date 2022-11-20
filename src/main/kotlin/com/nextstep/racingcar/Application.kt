package com.nextstep.racingcar

import com.nextstep.racingcar.domain.RacingGame
import com.nextstep.racingcar.domain.rules.RandomMoveRule
import com.nextstep.racingcar.view.CliInputView
import com.nextstep.racingcar.view.CliResultView

fun main() {
    val randomMoveRule = RandomMoveRule()
    val cliInputView = CliInputView()
    val cliResultView = CliResultView()
    val racingGame = RacingGame(randomMoveRule, cliInputView, cliResultView)
    racingGame.start()
}
