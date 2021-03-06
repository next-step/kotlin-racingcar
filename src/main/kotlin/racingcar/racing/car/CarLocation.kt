package racingcar.racing.car

import racingcar.racing.car.engine.Torque

data class CarLocation(val value: Int) {
    fun moveBy(torque: Torque): CarLocation {
        return CarLocation(this.value + torque.value)
    }

    companion object {
        val ZERO = CarLocation(0)
    }
}
