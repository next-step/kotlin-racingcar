package com.nextstep.racingcar.domain

class MoveHistory {
    private val histories = mutableListOf<Movement>()

    fun saveHistory(movement: Movement) {
        histories.add(movement)
    }

    fun getHistories(): List<Movement> {
        return histories.toList()
    }
}
