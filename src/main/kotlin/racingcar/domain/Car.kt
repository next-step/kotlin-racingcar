package racingcar.domain

import racingcar.util.NumberGenerator

data class Car(private val numberGenerator: NumberGenerator) {
    private var position = 1

    fun move() {
        if (movable()) {
            position += 1
        }
    }

    fun movable(): Boolean = numberGenerator.getNumber() >= 4

    fun getPosition(): Int = position
}
