package racing.domain.car

import racing.domain.exception.CarNameLengthExcessException

data class Car(
    private val _carName: String,
    private var _moveCount: Int = 0
) {
    private var _positionByRound: MutableMap<Int, Int> = mutableMapOf()

    init {
        if (!CAR_NAME_RANGE.contains(_carName.trim().length)) {
            throw CarNameLengthExcessException("자동차 이름은 ${CAR_NAME_RANGE.first}자 이상이어야 하고, ${CAR_NAME_RANGE.last}자를 초과할 수 없습니다.")
        }
    }

    val carName: String
        get() = _carName

    val moveCount: Int
        get() = _moveCount

    val positionByRound: MutableMap<Int, Int>
        get() = _positionByRound

    fun move(round: Int, number: Int) {
        if (canMoveForward(number)) {
            moveForward()
        }

        recordByRound(round)
    }

    fun canMoveForward(number: Int) = number >= MOVE_CONDITION

    fun moveForward() = _moveCount++

    private fun recordByRound(round: Int) {
        _positionByRound[round] = _moveCount
    }

    companion object {
        private val CAR_NAME_RANGE = 1..5
        private const val MOVE_CONDITION = 4
    }
}
