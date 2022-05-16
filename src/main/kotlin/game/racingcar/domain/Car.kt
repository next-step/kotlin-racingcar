package game.racingcar.domain

import game.racingcar.strategy.MoveStrategy

class Car(val name: String) {
    private val _blackBox: MutableList<Int> = mutableListOf()
    private var _position: Int = 0

    val blackBox: List<Int>
        get() = _blackBox.toList()
    val position: Int
        get() = _position

    fun move(moveStrategy: MoveStrategy): Int {
        _position = moveStrategy.move(_position)
        _blackBox.add(_position)
        return _position
    }

    fun history(time: Int) = blackBox[time]
}
