package racingcar

class Car(val distanceMoved: Int = 0) {

    fun move(fuel: Int): Car {
        if (isEnoughFuelToMove(fuel)) return Car(this.distanceMoved.inc())
        return this
    }

    private fun isEnoughFuelToMove(fuel: Int): Boolean {
        return fuel >= MINIMUM_FUEL_TO_MOVE
    }

    companion object {
        const val MINIMUM_FUEL_TO_MOVE = 4
    }
}
