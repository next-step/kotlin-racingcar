package racing.model

import racing.Movable

class Car(private val name: String, private var position: Int = START_POSITION) {
    init {
        require(position >= MIN_POSITION) { INVALID_CAR_POSITION }
        require(name.length <= MAX_NAME_LENGTH) { INVALID_CAR_NAME_LENGTH }
        require(name.isNotBlank()) { INVALID_CAR_NAME_BLANK }
    }

    fun move(movable: Movable): CarMoveResult {
        if (movable.canMove())
            position++
        return CarMoveResult(name, position)
    }

    companion object {
        private const val START_POSITION = 0
        private const val MIN_POSITION = 0
        private const val MAX_NAME_LENGTH = 5
        const val INVALID_CAR_POSITION = "자동차의 초기 위치는 0이상 입니다."
        const val INVALID_CAR_NAME_LENGTH = "자동차의 이름은 5자를 초과할 수 없습니다."
        const val INVALID_CAR_NAME_BLANK = "자동차의 이름은 공백이 될 수 없습니다."
    }
}
