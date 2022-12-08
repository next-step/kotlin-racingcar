package com.nextstep.racingcar.domain

import com.nextstep.racingcar.domain.rules.MoveRule

class Car(val name: String) {
    private val histories = MoveHistory()

    init {
        require(name.isNotBlank() && name.length <= 5) { "car name should be shorter than 6 letters and not empty, name: $name" }
    }

    fun move(moveRule: MoveRule) {
        val movement = moveRule.move()
        histories.saveHistory(movement)
    }

    fun getHistories(): List<Movement> {
        return histories.getHistories()
    }

    fun getLocation(): Int = histories.getLocation()
}
