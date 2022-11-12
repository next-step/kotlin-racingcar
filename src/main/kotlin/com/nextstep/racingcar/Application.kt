package com.nextstep.racingcar

import com.nextstep.racingcar.domain.NumberMoveRule
import com.nextstep.racingcar.domain.RacingGame
import com.nextstep.racingcar.domain.RandomNumberGenerator

fun main() {
    val randomNumberGenerator = RandomNumberGenerator()
    val numberMoveRule = NumberMoveRule()
    val racingGame = RacingGame(randomNumberGenerator, numberMoveRule)
    racingGame.start()
}
