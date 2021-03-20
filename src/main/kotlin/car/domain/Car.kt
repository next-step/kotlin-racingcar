package car.domain

import car.domain.history.CarMoveHistory
import car.domain.history.CarMoveHistoryCollection
import car.domain.move.MovableStrategy

class Car(
    val carName: CarName,
    position: Int = INIT_POSITION,
    private val movableStrategy: MovableStrategy
) {
    private val _histories: MutableList<CarMoveHistory> = mutableListOf()

    var currentPosition: Int = position
        private set

    val historyCollection: CarMoveHistoryCollection
        get() = CarMoveHistoryCollection(_histories)

    constructor(
        carName: String,
        position: Int = INIT_POSITION,
        movableStrategy: MovableStrategy
    ) : this(CarName(carName), position, movableStrategy)

    fun move() {
        if (movableStrategy.movable) {
            currentPosition++
        }
        _histories.add(CarMoveHistory(carName, currentPosition))
    }

    companion object {
        const val INIT_POSITION = 0
    }
}
