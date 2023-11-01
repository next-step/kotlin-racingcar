package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingCar(val name: String, private val racingGameMoveRule: RacingGameMoveRule) {
    var position: Int = 0
        private set

    fun moveForward() {
        if (racingGameMoveRule.isForward()) position++
    }

    override fun toString(): String {
        return "RacingCar(position=$position)"
    }

    fun copy(): RacingCar {
        val racingCar = RacingCar(name, racingGameMoveRule)
        racingCar.position = position
        return racingCar
    }
}
