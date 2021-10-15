package racingcar.domain

class Car(val carNumber: Int, val position: Int = 0) {

    init {
        require(position >= 0)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (carNumber != other.carNumber) return false

        return true
    }

    override fun hashCode(): Int {
        return carNumber
    }
}
