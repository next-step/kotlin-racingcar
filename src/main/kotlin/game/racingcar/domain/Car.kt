package game.racingcar.domain

import game.racingcar.strategy.MoveStrategy

class Car {
    var blackBox = arrayListOf<Int>()
    var position: Int = 0

    fun move(moveStrategy: MoveStrategy): Int {
        position = moveStrategy.move(position)
        blackBox.add(position)
        return position
    }

    fun history(time: Int): Int {
        return blackBox[time]
    }
}
