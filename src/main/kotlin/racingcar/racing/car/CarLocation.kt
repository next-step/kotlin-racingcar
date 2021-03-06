package racingcar.racing.car

import racingcar.racing.car.engine.Torque

data class CarLocation(val value: Int) : Comparable<CarLocation> {
    fun moveBy(torque: Torque): CarLocation {
        return CarLocation(this.value + torque.value)
    }

    override fun compareTo(other: CarLocation): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        val ZERO = CarLocation(0)
    }
}
