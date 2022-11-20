package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE

class MoveHistory {
    private val histories = mutableListOf<Movement>()

    fun saveHistory(movement: Movement) {
        histories.add(movement)
    }

    fun getHistories(): List<Movement> {
        return histories.toList()
    }

    fun getLocation(): Int = histories.count { it == MOVE }
}
