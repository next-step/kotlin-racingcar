package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.rules.MoveRule

class Car {
    private val histories = MoveHistory()

    fun move(moveRule: MoveRule) {
        val movement = moveRule.move()
        histories.saveHistory(movement)
    }

    fun getHistories(): List<Movement> {
        return histories.getHistories()
    }
}
