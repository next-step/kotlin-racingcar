package racingcar.domain

import racingcar.util.NumberGenerator

data class Car(val name: String, private val numberGenerator: NumberGenerator) {
    private var position = START_POSITION

    init {
        if (name.trim().length !in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {
            throw IllegalArgumentException(NAME_ERROR_MESSAGE)
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

        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5

        const val NAME_ERROR_MESSAGE = "자동차 이름은 $MIN_NAME_LENGTH~${MAX_NAME_LENGTH}자만 가능합니다."
    }
}
