package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingCar(private val racingGameMoveRule: RacingGameMoveRule) {
    var position: Int = 0

    fun moveForward() {
        if (racingGameMoveRule.isForward())
            position++
    }
}
