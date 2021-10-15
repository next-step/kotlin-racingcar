package racingcar.domain

class Car(
    val carNumber: Int,
    val position: Int = 0,
    private val movingStrategy: MovingStrategy = RandomMoveStrategy()
) {

    init {
        require(position >= 0)
    }

    fun moveForward(): Car {
        if (movingStrategy.canMove()) {
            return Car(carNumber, position + 1)
        }
        return this
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
