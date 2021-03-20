package car.domain

import car.domain.history.CarMoveHistory
import car.domain.history.CarMoveHistoryCollection
import car.domain.move.MovableStrategy

class Car(val carName: CarName, position: Int = INIT_POSITION, private val movableStrategy: MovableStrategy) {
    private val _histories: MutableList<CarMoveHistory> = mutableListOf()

    var currentPosition: Int = position
        private set

    val historyCollection: CarMoveHistoryCollection
        get() = CarMoveHistoryCollection(_histories)

    constructor(
        carName: String,
        movableStrategy: MovableStrategy
    ) : this(CarName(carName), INIT_POSITION, movableStrategy)

    constructor(
        carName: CarName,
        movableStrategy: MovableStrategy
    ) : this(carName, INIT_POSITION, movableStrategy)

    fun move() {
        if (movableStrategy.movable) {
            currentPosition++
        }
        _histories.add(CarMoveHistory(carName, currentPosition))
    }

    fun isWinner(winnerPosition: Int): Boolean {
        return currentPosition == winnerPosition
    }

    companion object {
        const val INIT_POSITION = 0
    }
}
