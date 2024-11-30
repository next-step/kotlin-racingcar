package study.racingcar.util

class Move {
    fun getRandomMoveCount(): Int {
        return (START_INDEX..END_INDEX).random()
    }

    fun isMove(
        distance: Int,
        validCondition: Int,
        moveStrategy: MoveStrategy,
    ): Boolean {
        return moveStrategy.isMove(distance, validCondition)
    }

    companion object {
        private const val START_INDEX = 0
        private const val END_INDEX = 9
    }
}
