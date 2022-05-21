package racing.car

import racing.utils.RandomNumberGenerator

data class Car(
    private val carName: String,
    private var moveCount: Int = 0
) {

    fun move() {
        if (canMoveForward(RandomNumberGenerator.getRandomNumber())) {
            moveForward()
        }
    }
    fun canMoveForward(number: Int) = number >= MOVE_CONDITION

    fun moveForward() = this.moveCount++

    fun getMoveCount(): Int {
        return this.moveCount
    }

    fun getCarName(): String {
        return this.carName
    }

    companion object {
        const val MOVE_CONDITION = 4
    }
}
