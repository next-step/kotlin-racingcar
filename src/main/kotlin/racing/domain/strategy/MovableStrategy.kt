package racing.domain.strategy

import racing.domain.DirectionType

fun interface MovableStrategy {
    fun movable(): DirectionType
}
