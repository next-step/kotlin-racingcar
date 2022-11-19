package racingcarWinner.domain

import racingcarWinner.util.MessageCode

class Car(
    val carName: String
) {
    var moveStep: Int = DEFAULT_MOVE_STEP
        private set

    init {
        require(carName.length > CAR_NAME_LENGTH_MIN_LIMIT) { MessageCode.CarNameMInLengthException.message }

        require(carName.length <= CAR_NAME_LENGTH_MAX_LIMIT) { MessageCode.CarNameMaxLengthException.message }
    }

    private fun isMovable(condition: Int): Boolean =
        condition >= MOVE_LIMIT

    fun move(condition: Int) {
        if (isMovable(condition)) moveStep++
    }

    fun isSameDistance(distance: Int): Boolean =
        distance == moveStep

    companion object {
        const val CAR_NAME_LENGTH_MIN_LIMIT = 0
        const val CAR_NAME_LENGTH_MAX_LIMIT = 5
        private const val MOVE_LIMIT = 4
        private const val DEFAULT_MOVE_STEP = 0
    }
}
