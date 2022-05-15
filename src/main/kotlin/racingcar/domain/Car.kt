package racingcar.domain

import racingcar.domain.MovementCommand.FORWARD

class Car(
    val name: String
) {
    var position: Int = 0
        private set

    init {
        require(name.isNotBlank()) { "이름은 공백일 수 없습니다." }
        require(name.length in NAME_LENGTH_RANGE) { "이름은 최소 1글자, 최대 5글자이어야 합니다." }
    }

    fun move(movementCommand: MovementCommand) {
        if (movementCommand == FORWARD) position += movementCommand.power
    }

    fun captureState() = State(name, position)

    companion object {
        private val NAME_LENGTH_RANGE = 1..5
    }

    data class State(
        val name: String,
        val currentPosition: Int
    )
}
