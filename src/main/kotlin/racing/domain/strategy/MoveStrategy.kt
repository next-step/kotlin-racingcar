package racing.domain.strategy

import racing.domain.Distance

fun interface MoveStrategy {
    fun move(baseDistance: Distance, navigator: Navigator): Distance
}
