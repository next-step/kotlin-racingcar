package com.nextstep.racingcar.domain

class Car {
    var position: Int = 0
        private set

    fun move(randomNumber: Int) {
        if (randomNumber.movable()) {
            position = position.inc()
        }
    }

    private fun Int.movable(): Boolean {
        return this >= MIN_MOVABLE_NUMBER
    }

    companion object {
        const val MIN_MOVABLE_NUMBER = 4
    }
}
