package racing.domain.strategy

import racing.domain.Distance

fun interface MoveStrategy {
    fun move(movableStrategy: MovableStrategy, baseDistance: Distance): Distance
}
