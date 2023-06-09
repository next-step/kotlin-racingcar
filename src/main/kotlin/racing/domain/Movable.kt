package racing.domain

import racing.domain.strategy.MoveStrategy

fun interface Movable {
    fun move(strategy: MoveStrategy)
}
