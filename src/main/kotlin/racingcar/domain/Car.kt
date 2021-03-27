package racingcar.domain

class Car(
    val name: Name,
    val distance: Distance = Distance()
) : Comparable<Car> {

    fun move(number: Number): Car {
        if (number >= MOVE_POINT) {
            return Car(name = name, distance = distance + MOVE_DISTANCE)
        }
        return this
    }

    fun isSameDistance(distance: Distance) = this.distance == distance

    override fun compareTo(other: Car) = this.distance.compareTo(other.distance)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return "Car(name=$name, distance=$distance)"
    }

    companion object {
        private val MOVE_POINT = Number(4)
        private val MOVE_DISTANCE = Distance(1)
    }
}
