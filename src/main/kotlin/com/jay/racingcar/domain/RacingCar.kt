package com.jay.racingcar.domain

class RacingCar(
    private val movingStrategy: MovingStrategy,
    internal var position: Int = 0
) {
    fun move() {
        if (movingStrategy.canMove()) position++
    }
}
