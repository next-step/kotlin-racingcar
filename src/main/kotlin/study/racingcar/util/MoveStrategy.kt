package study.racingcar.util

interface MoveStrategy {
    fun isMove(
        distance: Int,
        validCondition: Int,
    ): Boolean
}

class TargetGEvalidConditionMoveStrategy : MoveStrategy {
    override fun isMove(
        distance: Int,
        validCondition: Int,
    ): Boolean {
        return distance >= validCondition
    }
}

class TargetGTvalidConditionMoveStrategy : MoveStrategy {
    override fun isMove(
        distance: Int,
        validCondition: Int,
    ): Boolean {
        return distance > validCondition
    }
}
