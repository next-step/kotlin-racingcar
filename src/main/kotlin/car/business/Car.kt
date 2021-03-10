package car.business

class Car(val name: String) {

    internal var currentPosition: Int = INIT_POSITION
        private set

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH)
    }

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
        private const val MAXIMUM_NAME_LENGTH = 5
        const val INIT_POSITION = 0
    }
}
