package game.racingcar.domain

import game.racingcar.strategy.MoveStrategy

class Car {
    private val _blackBox: MutableList<Int> = mutableListOf()
    private var position: Int = 0

    val blackBox: List<Int>
        get() = _blackBox.toList()

    fun move(moveStrategy: MoveStrategy): Int {
        position = moveStrategy.move(position)
        _blackBox.add(position)
        return position
    }

    fun history(time: Int): Int {
        return blackBox[time]
    }

    fun position(): Int {
        return blackBox.lastOrNull() ?: 0
    }
}
