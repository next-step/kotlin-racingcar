package racing.domain.car

import racing.domain.exception.CarNameLengthExcessException

data class Car(
    private val _carName: String,
    private var _moveCount: Int = 0
) {
    private val _positions: MutableList<Int> = mutableListOf()

    init {
        if (!CAR_NAME_RANGE.contains(_carName.trim().length)) {
            throw CarNameLengthExcessException("자동차 이름은 ${CAR_NAME_RANGE.first}자 이상이어야 하고, ${CAR_NAME_RANGE.last}자를 초과할 수 없습니다.")
        }
    }

    val carName: String
        get() = _carName

    val moveCount: Int
        get() = _moveCount

    val positions: List<Int>
        get() = _positions.toList()

    fun move(number: Int) {
        if (canMoveForward(number)) {
            moveForward()
        }

        recordByRound()
    }

    private fun canMoveForward(number: Int) = number >= MOVE_CONDITION

    private fun moveForward() = _moveCount++

    private fun recordByRound() {
        _positions.add(_moveCount)
    }

    companion object {
        private val CAR_NAME_RANGE = 1..5
        private const val MOVE_CONDITION = 4
    }
}
