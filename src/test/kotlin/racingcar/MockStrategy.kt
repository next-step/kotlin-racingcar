package racingcar

import racingcar.domain.MovingConditionStrategy

class MockStrategy(private val carNumber: Int = 0) : MovingConditionStrategy {
    override fun move(): Int {
        if (carNumber == ALL_CAR_MOVE_WINNER_NUMBER) {
            return MOVE
        }
        if (GAME % 3 == carNumber) {
            GAME++
            return MOVE
        }
        GAME++
        return STOP
    }

    companion object {
        const val STOP = 1
        const val MOVE = 5
        const val ALL_CAR_MOVE_WINNER_NUMBER = 4
        var GAME = 0
    }
}
