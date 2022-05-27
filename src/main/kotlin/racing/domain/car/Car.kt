package racing.domain.car

import racing.domain.utils.RandomNumberGenerator

data class Car(
    private val _carName: String,
    private var _moveCount: Int = 0,
) {

    val carName: String
        get() { return _carName }

    val moveCount: Int
        get() { return _moveCount }

    fun move() {
        if (canMoveForward(RandomNumberGenerator.getRandomNumber())) {
            moveForward()
        }
    }

    fun canMoveForward(number: Int) = number >= MOVE_CONDITION

    fun moveForward() = this._moveCount++

    companion object {
        private const val MOVE_CONDITION = 4
    }
}
