package com.racing.step3.domain

class Car(
    val position: Int = 0
) {
    fun move(moveTrigger: () -> Int): Car {
        return if (moveTrigger() >= 4) Car(position + 1) else this
    }
}
