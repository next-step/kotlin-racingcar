package car.domain

class Car(val name: CarName) {

    internal var currentPosition: Int = INIT_POSITION
        private set

    constructor(name: String) : this(CarName(name))

    fun move(energy: Int) {
        if (isMovable(energy)) {
            currentPosition++
        }
    }

    private fun isMovable(energy: Int): Boolean {
        return energy >= MOVE_CONDITION_ENERGY
    }

    companion object {
        private const val MOVE_CONDITION_ENERGY = 4
        const val INIT_POSITION = 0
    }
}
