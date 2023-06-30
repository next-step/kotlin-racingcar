package racingcar.domain

import racingcar.util.NumberGenerator

data class Car(val name: String, private val numberGenerator: NumberGenerator) {
    var position = START_POSITION
        private set

    init {
        require(name.trim().length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { NAME_ERROR_MESSAGE }
    }

    fun move() {
        if (movable()) {
            position += STEP
        }
    }

    fun movable(): Boolean = numberGenerator.getNumber() >= MOVE_THRESHOLD

    companion object {
        const val START_POSITION = 1
        const val STEP = 1
        const val MOVE_THRESHOLD = 4

        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5

        const val NAME_ERROR_MESSAGE = "자동차 이름은 $MIN_NAME_LENGTH~${MAX_NAME_LENGTH}자만 가능합니다."
    }
}
