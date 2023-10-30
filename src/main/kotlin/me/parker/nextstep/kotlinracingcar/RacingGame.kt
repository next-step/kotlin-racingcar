package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingGame(
    val numOfRacingCar: Int, val numOfAttempts: Int,
    val racingGameMoveRule: RacingGameMoveRule
) {
}
