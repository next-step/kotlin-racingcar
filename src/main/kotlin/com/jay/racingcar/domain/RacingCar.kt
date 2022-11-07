package com.jay.racingcar.domain

class RacingCar(
    private val movingStrategy: MovingStrategy,
    var position: Int = 0
) {
    fun move() {
        if (movingStrategy.canMove()) position++
    }
}
