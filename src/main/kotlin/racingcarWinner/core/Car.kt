package racingcarWinner.core

class Car(
    val carName: String
) {
    var moveStep: Int = DEFAULT_MOVE_STEP

    init {
        require(carName.length > CAR_NAME_LENGTH_MIN_LIMIT) { MessageCode.CarNameMInLengthException.message }

        require(carName.length <= CAR_NAME_LENGTH_MAX_LIMIT) { MessageCode.CarNameMaxLengthException.message }
    }

    private fun isMovable(randomNumber: Int): Boolean =
        randomNumber >= MOVE_LIMIT

    fun move(randomNumber: Int) {
        if (isMovable(randomNumber)) moveStep++
    }

    companion object {
        const val CAR_NAME_LENGTH_MIN_LIMIT = 0
        const val CAR_NAME_LENGTH_MAX_LIMIT = 5
        private const val MOVE_LIMIT = 4
        private const val DEFAULT_MOVE_STEP = 0
    }
}
