package racingcar.game.domain

import racingcar.game.vo.Position

const val FORWARD_CRITERIA_NUMBER = 4

const val START_LINE = 0

class Car {
    var position: Position = Position(START_LINE)
        private set

    fun move(condition: Int) {
        if (condition >= FORWARD_CRITERIA_NUMBER) {
            position.num++
        }
    }
}
