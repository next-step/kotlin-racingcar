package car.racing.domain

class Car(
    turnCount: Int,
) {

    private val conditionsOfTurn = Array(turnCount + 1) { "" }

    fun getMoveDistanceUntilTurn(turn: Int): String {
        return conditionsOfTurn.slice(IntRange(0, turn))
            .filter { it.isNotBlank() }
            .joinToString(SEPARATOR)
    }

    fun move(turn: Int, condition: Int): String {
        val status = getStatus(condition)

        conditionsOfTurn[turn] = status

        return status
    }

    private fun getStatus(condition: Int): String {
        return if (isMoveable(condition)) {
            MOVE
        } else {
            STAY
        }
    }

    private fun isMoveable(condition: Int) = condition >= 4

    companion object {
        private const val MOVE = "-"
        private const val STAY = ""
        private const val SEPARATOR = ""
    }
}
