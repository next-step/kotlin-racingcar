package car.domain

abstract class MovableCar(val carName: CarName, var _position: Int = INIT_POSITION) {
    private val _histories: MutableList<CarMoveHistory> = mutableListOf()

    val currentPosition: Int
        get() = _position
    val historyCollection: CarMoveHistoryCollection
        get() = CarMoveHistoryCollection(_histories)

    fun move() {
        moveCar()

        _histories.add(CarMoveHistory(carName, _position))
    }

    fun isWinner(winnerPosition: Int): Boolean {
        return currentPosition == winnerPosition
    }

    protected abstract fun moveCar()

    companion object {
        const val INIT_POSITION = 0
    }
}
