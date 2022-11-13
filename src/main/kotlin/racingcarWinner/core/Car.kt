package racingcarWinner.core

class Car(
    private val carName: String
) {
    var moveStep: Int = 0
        private set

    init {
        if (carName.count() > CAR_NAME_LENGTH_LIMIT) throw IllegalArgumentException(MessageCode.CarNameLengthException.message)
    }

    private fun isMovable(randomNumber: Int): Boolean =
        randomNumber >= MOVE_LIMIT

    fun move(randomNumber: Int) {
        if (isMovable(randomNumber)) moveStep++
    }

    companion object {
        private const val CAR_NAME_LENGTH_LIMIT = 5
        private const val MOVE_LIMIT = 4
    }
}
