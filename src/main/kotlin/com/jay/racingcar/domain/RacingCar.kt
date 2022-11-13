package com.jay.racingcar.domain

class RacingCar(
    private var name: Name,
    private val movingStrategy: MovingStrategy,
    private var position: Int = 0
) {
    fun move() {
        if (movingStrategy.canMove()) position++
    }

    fun getPosition(): Int = position
    fun getNameValue(): String = name.value
}
