package racing.domain.strategy

import racing.domain.DirectionType
import racing.domain.Distance

class StopOrStraightMoveStrategy(private val additionalDistance: Distance) : MoveStrategy {

    override fun move(movableStrategy: MovableStrategy, baseDistance: Distance): Distance {
        return totalDistance(baseDistance).takeIf { movableStrategy.movable() == DirectionType.STRAIGHT } ?: Distance.ZERO
    }

    private fun totalDistance(baseDistance: Distance) = additionalDistance + baseDistance
}
