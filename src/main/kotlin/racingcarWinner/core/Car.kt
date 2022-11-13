package racingcarWinner.core

class Car(
    val carName: String
) {
    var moveStep: Int = 0

    init {
        val carNameCount = carName.count()
        if (carNameCount <= CAR_NAME_LENGTH_MIN_LIMIT) {
            throw IllegalArgumentException(MessageCode.CarNameMInLengthException.message)
        }

        if (carNameCount > CAR_NAME_LENGTH_MAX_LIMIT) {
            throw IllegalArgumentException(MessageCode.CarNameMaxLengthException.message)
        }
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
    }
}
