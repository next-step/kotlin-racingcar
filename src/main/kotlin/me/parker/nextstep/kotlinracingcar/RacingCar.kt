package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingCar(private val racingGameMoveRule: RacingGameMoveRule) {
    var position: Int = 0
        private set
    val moveRecords: MutableList<Int> = mutableListOf()

    fun moveForward() {
        if (racingGameMoveRule.isForward()) position++

        moveRecords.add(position)
    }

    override fun toString(): String {
        return "RacingCar(position=$position)"
    }
}
