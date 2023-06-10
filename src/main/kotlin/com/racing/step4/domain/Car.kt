package com.racing.step4.domain

class Car(
    val name: String,
    val position: Int = 0
) {

    fun move(moveTrigger: () -> Int): Car {
        return if (moveTrigger() >= MOVE_TRIGGER_VALUE) Car(name, position + 1) else this
    }

    override fun toString(): String {
        return name + " : " + "-".repeat(position) + "\n"
    }

    companion object {
        private const val MOVE_TRIGGER_VALUE = 4
    }
}
