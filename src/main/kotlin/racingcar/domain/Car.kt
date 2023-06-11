package racingcar.domain

import racingcar.util.NumberGenerator

data class Car(private val numberGenerator: NumberGenerator) {
    private var position = START_POSITION

    fun move() {
        if (movable()) {
            position += STEP
        }
    }

    fun movable(): Boolean = numberGenerator.getNumber() >= MOVE_THRESHOLD

    fun getPosition(): Int = position

    companion object {
        private const val START_POSITION = 1
        private const val STEP = 1
        private const val MOVE_THRESHOLD = 4
    }
}
