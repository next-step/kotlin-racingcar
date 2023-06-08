package racing.domain

import racing.domain.strategy.MoveStrategy

class Car(private var distance: Distance) : Movable {
    constructor() : this(Distance(0L))

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

    companion object {
        private val MOVING_DISTANCE: Distance = Distance(1L)
    }
}
