package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.Movement.MOVE

class MoveHistory(histories: MutableList<Movement> = mutableListOf()) {
    private val histories = histories.toMutableList()

    fun saveHistory(movement: Movement) {
        histories.add(movement)
    }

    fun getHistories(): List<Movement> {
        return histories.toList()
    }

    fun getLocation(): Int = histories.count { it == MOVE }
}
