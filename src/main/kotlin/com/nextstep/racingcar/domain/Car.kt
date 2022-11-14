package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.gamerules.MoveRule

class Car {
    private val histories = mutableListOf<Movement>()

    fun move(moveRule: MoveRule) {
        val movement = moveRule.move()
        saveHistory(movement)
    }

    private fun saveHistory(movement: Movement) {
        histories.add(movement)
    }

    fun getHistories(): List<Movement> {
        return histories.toList()
    }
}
