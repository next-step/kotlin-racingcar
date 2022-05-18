package game.racingcar.domain

import game.racingcar.strategy.MoveStrategy

class Car(val name: String) {
    private val _blackBox: MutableList<Int> = mutableListOf()

    val blackBox: List<Int>
        get() = _blackBox.toList()
    val position: Int
        get() = _blackBox.lastOrNull() ?: 0

    fun move(moveStrategy: MoveStrategy): Int {
        _blackBox.add(moveStrategy.move(position))
        return position
    }

    fun history(time: Int): Int = blackBox[time]
}
