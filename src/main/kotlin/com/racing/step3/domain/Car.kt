package com.racing.step3.domain

class Car(
    val position: Int = 0
) {

    fun move(moveTrigger: () -> Int): Car {
        return if (moveTrigger() >= MOVE_TRIGGER_VALUE) Car(position + 1) else this
    }

    companion object {
        private const val MOVE_TRIGGER_VALUE = 4
    }
}
