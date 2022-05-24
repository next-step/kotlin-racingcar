package racingcar

data class Car(val distanceMoved: Int = 0, private val name: CarName) {

    fun name(): String {
        return name.value
    }

    fun moveForward(fuel: Int): Car {
        if (isEnoughFuelToMove(fuel)) {
            return this.copy(distanceMoved = this.distanceMoved.inc())
        }
        return this
    }

    private fun isEnoughFuelToMove(fuel: Int): Boolean {
        return fuel >= MINIMUM_FUEL_TO_MOVE
    }

    companion object {
        const val MINIMUM_FUEL_TO_MOVE = 4
    }
}
