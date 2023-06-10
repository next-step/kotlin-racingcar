package racing.domain

import racing.domain.strategy.MovableStrategy
import racing.domain.strategy.MoveStrategy
import racing.domain.strategy.StopOrStraightMoveStrategy

class Car(
    id: Int,
    distance: Distance = Distance.ZERO,
    private val moveStrategy: MoveStrategy = StopOrStraightMoveStrategy(MOVING_DISTANCE) /*이동 전략은 현재는 다른 전략을 가지지 않기에 default 전략을 설정한다.*/
) : Movable, Comparable<Car> {

    var distance: Distance = distance
        private set

    var id: Int = id
        internal set

    override fun move(strategy: MovableStrategy) {
        distance = moveStrategy.move(movableStrategy = strategy, baseDistance = distance)
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Car) {
            this.distance == other.distance && this.id == other.id
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return distance.hashCode()
    }

    override fun compareTo(other: Car): Int = distance compareTo other.distance

    companion object {
        private val MOVING_DISTANCE: Distance = Distance(1L)
    }
}
