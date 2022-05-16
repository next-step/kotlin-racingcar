package racing.car

data class Car(
    private val carName: String,
    private var moveCount: Int
) {
    fun canMoveForward(number: Int) = number >= MOVE_CONDITION

    fun setMoveCount(moveCount: Int) {
        this.moveCount += moveCount
    }

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
