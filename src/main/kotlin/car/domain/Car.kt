package car.domain

class Car(val carName: CarName, private val movableStrategy: MovableStrategy) {
    private val _histories: MutableList<CarMoveHistory> = mutableListOf()

    private var _position: Int = INIT_POSITION

    val currentPosition: Int
        get() = _position
    val historyCollection: CarMoveHistoryCollection
        get() = CarMoveHistoryCollection(_histories)

    constructor(carName: String, movableStrategy: MovableStrategy) : this(CarName(carName), movableStrategy)

    fun move() {
        if (movableStrategy.isMovable()) {
            _position++
        }
        _histories.add(CarMoveHistory(carName, _position))
    }

    fun isWinner(winnerPosition: Int): Boolean {
        return currentPosition == winnerPosition
    }

    companion object {
        const val INIT_POSITION = 0
    }
}
