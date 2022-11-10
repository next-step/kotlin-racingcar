package com.nextstep.racingcar.domain

class Car {
    private val histories = mutableListOf<Movement>()

    fun move(numberGenerator: NumberGenerator, moveRule: MoveRule): Movement {
        val number = numberGenerator.generate()
        return moveRule.movable(number)
    }

    fun saveHistory(movement: Movement) {
        histories.add(movement)
    }

    fun getHistories(): List<Movement> {
        return histories.toList()
    }
}
