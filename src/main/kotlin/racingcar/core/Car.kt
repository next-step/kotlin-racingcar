package racingcar.core

class Car {
    val moveStep = mutableListOf<String>()

    private fun isMovable(randomNumber: Int): Boolean =
        randomNumber >= MOVE_LIMIT

    fun move(randomNumber: Int) {
        if (isMovable(randomNumber)) moveStep.add(MOVE_STEP)
    }

    companion object {
        private const val MOVE_LIMIT = 4
        private const val MOVE_STEP = "-"
    }
}
