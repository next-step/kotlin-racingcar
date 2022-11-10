package racingcar.condition

import racingcar.const.MoveConditionType

class NotMoveCondition : MoveCondition {
    override val conditionType: MoveConditionType = MoveConditionType.NOT_MOVE
    override fun isAvailable(): Boolean {
        return false
    }
}
