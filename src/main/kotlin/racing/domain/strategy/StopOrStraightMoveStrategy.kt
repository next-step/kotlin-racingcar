package racing.domain.strategy

import racing.domain.DirectionType
import racing.domain.Distance

class StopOrStraightMoveStrategy(private val additionalDistance: Distance) : MoveStrategy {

    override fun move(baseDistance: Distance, navigator: Navigator): Distance {
        return totalDistance(baseDistance).takeIf { navigator.navigate() == DirectionType.STRAIGHT } ?: baseDistance
    }

    private fun totalDistance(baseDistance: Distance) = additionalDistance + baseDistance
}
