package car.racing.domain

import car.racing.exception.OutOfRangeException
import car.racing.usecase.MovingStrategy

class Car(
    val name: String,
    private val turnCount: Int,
    private val movingStrategy: MovingStrategy,
) {

    private var currentTurn = 0
    private val conditionsOfTurn = Array(turnCount) { false }

    init {
        require(name.length < NAME_MAX_LENGTH) { "이름의 길이는 $NAME_MAX_LENGTH 보다 작아야합니다." }
    }

    fun getMovesUntilTurn(turn: Int): List<Boolean> {
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

    companion object {
        private const val NAME_MAX_LENGTH = 5
    }
}
