package com.nextstep.jngcii.racingcar.domain

open class Car(val name: String) {
    open val speed = SPEED
    private var _distance = ZERO_DISTANCE
    open val distance get() = _distance

    open fun go(dice: Dice) {
        _distance += dice.run().intBySpeed
    }

    private val Boolean.intBySpeed get() = if (this) speed else ZERO_DISTANCE

    companion object {
        private const val ZERO_DISTANCE = 0
        private const val SPEED = 1
    }
}
