package car.domain

class Car(val name: CarName, private val energyProvider: EnergyProvider) : MovableCar {

    private var _position: Int = INIT_POSITION

    override val currentPosition: Int
        get() = _position

    constructor(name: String, energyProvider: EnergyProvider) : this(CarName(name), energyProvider)

    override fun move() {
        if (isMovable()) {
            _position++
        }
    }

    private fun isMovable(): Boolean {
        return energyProvider.energy >= MOVE_CONDITION_ENERGY
    }

    companion object {
        private const val MOVE_CONDITION_ENERGY = 4
        const val INIT_POSITION = 0
    }
}
