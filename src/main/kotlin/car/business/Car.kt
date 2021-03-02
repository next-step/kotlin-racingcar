package car.business

class Car(val name: String) {
    internal var currentPosition: Int = 0
        private set

    fun move(energy: Int) {
        if (!isMovable(energy)) return

        currentPosition++
    }

    fun isMovable(energy: Int): Boolean {
        return energy >= MOVE_CONDITION_ENERGY
    }

    companion object {
        val MOVE_CONDITION_ENERGY = 4
    }
}
