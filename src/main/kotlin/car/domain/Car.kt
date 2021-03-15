package car.domain

class Car(val carName: CarName, private val energyProvider: EnergyProvider) {
    private val _histories: MutableList<CarMoveHistory> = mutableListOf()

    private var _position: Int = INIT_POSITION

    val currentPosition: Int
        get() = _position
    val historyCollection: CarMoveHistoryCollection
        get() = CarMoveHistoryCollection(_histories)

    constructor(carName: String, energyProvider: EnergyProvider) : this(CarName(carName), energyProvider)

    fun move() {
        if (isMovable()) {
            _position++
        }

        _histories.add(CarMoveHistory(carName, _position))
    }

    private fun isMovable(): Boolean {
        return energyProvider.energy >= MOVE_CONDITION_ENERGY
    }

    fun isWinner(winnerPosition: Int): Boolean {
        return currentPosition == winnerPosition
    }

    companion object {
        private const val MOVE_CONDITION_ENERGY = 4
        const val INIT_POSITION = 0
    }
}
