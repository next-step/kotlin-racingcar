package racingcar.core

class Car {
    var moveStep: Int = 0
        private set

    private fun isMovable(randomNumber: Int): Boolean =
        randomNumber >= MOVE_LIMIT

    fun move(randomNumber: Int) {
        if (isMovable(randomNumber)) moveStep++
    }

    companion object {
        private const val MOVE_LIMIT = 4
    }
}
