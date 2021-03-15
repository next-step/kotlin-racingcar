package car.domain

class Car(val _name: CarName, private val energyProvider: EnergyProvider) : MovableCar {

    private var _position: Int = INIT_POSITION
    private val _histories: MutableList<CarMoveHistory> = mutableListOf()

    override val currentPosition: Int
        get() = _position
    override val historyCollection: CarMoveHistoryCollection
        get() = CarMoveHistoryCollection(_histories)
    override val carName: CarName
        get() = _name

    constructor(_name: String, energyProvider: EnergyProvider) : this(CarName(_name), energyProvider)

    override fun move() {
        if (isMovable()) {
            _position++
        }

        _histories.add(CarMoveHistory(_name, _position))
    }

    private fun isMovable(): Boolean {
        return energyProvider.energy >= MOVE_CONDITION_ENERGY
    }

    companion object {
        private const val MOVE_CONDITION_ENERGY = 4
        const val INIT_POSITION = 0
    }
}
