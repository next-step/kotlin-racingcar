package racingcar

class Car(val status: Int = 0) {
    fun move() : Car {
        return Car(status + 1)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        return status
    }
}