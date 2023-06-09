package racing.domain

import racing.domain.strategy.MoveStrategy

class Car(private var id: Int, private var distance: Distance = Distance.ZERO) : Movable, Comparable<Car> {

    val getDistance: Distance
        get() = distance

    val getId: Int
        get() = id

    override fun move(strategy: MoveStrategy) {
        if (strategy.movable()) {
            distance += MOVING_DISTANCE
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return distance == other.distance
    }

    override fun hashCode(): Int {
        return distance.hashCode()
    }

    override fun compareTo(other: Car): Int = distance.compareTo(other.distance)

    companion object {
        private val MOVING_DISTANCE: Distance = Distance(1L)
    }
}
