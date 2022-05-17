package game.racingcar.domain

import game.racingcar.strategy.MoveStrategy

class Car(val name: String) {
    private val _blackBox: MutableList<Int> = mutableListOf()

    val blackBox: List<Int>
        get() = _blackBox.toList()
    var position: Int = 0
        private set

    fun move(moveStrategy: MoveStrategy): Int {
        position = moveStrategy.move(position)
        _blackBox.add(position)
        return position
    }

    fun history(time: Int) = blackBox[time]
}
