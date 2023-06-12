package racingcar.domain

import racingcar.util.NumberGenerator

data class Car(val name: String, private val numberGenerator: NumberGenerator) {
    private var position = START_POSITION

    init {
        if (name.trim().length !in 1..5) {
            throw IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.")
        }
    }

    fun move() {
        if (movable()) {
            position += STEP
        }
    }

    fun movable(): Boolean = numberGenerator.getNumber() >= MOVE_THRESHOLD

    fun getPosition(): Int = position

    companion object {
        const val START_POSITION = 1
        const val STEP = 1
        const val MOVE_THRESHOLD = 4
    }
}
