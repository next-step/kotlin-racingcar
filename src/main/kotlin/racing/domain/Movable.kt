package racing.domain

import racing.domain.strategy.MovableStrategy

fun interface Movable {
    fun move(strategy: MovableStrategy)
}
