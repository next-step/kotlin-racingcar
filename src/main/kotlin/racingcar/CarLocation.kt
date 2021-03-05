package racingcar

data class CarLocation(val value: Long) {
    operator fun plus(torque: Torque): CarLocation {
        return CarLocation(this.value + torque.value)
    }

    companion object {
        val ZERO = CarLocation(0L)
    }
}
