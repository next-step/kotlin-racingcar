package car.domain

class Car(_name: CarName, private val energyProvider: EnergyProvider) : MovableCar(_name) {
    constructor(_name: String, energyProvider: EnergyProvider) : this(CarName(_name), energyProvider)

    override fun moveCar() {
        if (isMovable()) {
            _position++
        }
    }

    private fun isMovable(): Boolean {
        return energyProvider.energy >= MOVE_CONDITION_ENERGY
    }

    companion object {
        private const val MOVE_CONDITION_ENERGY = 4
    }
}
