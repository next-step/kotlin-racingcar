package racing.domain

import racing.domain.strategy.Navigator

fun interface Movable {
    fun move(navigator: Navigator)
}
