package car.racing.domain

import car.racing.exception.OutOfRangeException
import car.racing.usecase.MovingStrategy

class Car(
    private val turnCount: Int,
    private val movingStrategy: MovingStrategy,
) {

    private var currentTurn = 0
    private val conditionsOfTurn = Array(turnCount) { false }

    fun getMoveDistanceUntilTurn(turn: Int): List<Boolean> {
        return conditionsOfTurn.slice(IntRange(0, turn))
    }

    fun move(): Boolean {
        if (currentTurn >= turnCount) {
            throw OutOfRangeException("move 메소드는 turnCount 보다 많이 실행될 수 없습니다. turnCount: $turnCount, move method call count: ${currentTurn + 1}")
        }

        val isMove = movingStrategy.isMoveable()
        conditionsOfTurn[currentTurn++] = isMove

        return isMove
    }
}
