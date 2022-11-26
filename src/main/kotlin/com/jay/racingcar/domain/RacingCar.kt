package com.jay.racingcar.domain

class RacingCar(
    private var name: Name,
    private val movingStrategy: MovingStrategy,
    private var position: Int = 0
) : Comparable<RacingCar> {
    fun move() {
        if (movingStrategy.canMove()) position++
    }

    fun getPosition(): Int = position

    fun getNameValue(): String = name.value

    override fun compareTo(other: RacingCar): Int {
        return other.position.compareTo(position)
    }
}
