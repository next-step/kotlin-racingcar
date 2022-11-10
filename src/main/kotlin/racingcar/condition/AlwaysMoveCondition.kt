package racingcar.condition

import racingcar.const.MoveConditionType

class AlwaysMoveCondition : MoveCondition {
    override val conditionType: MoveConditionType = MoveConditionType.ALWAYS_MOVE
    override fun isAvailable(): Boolean {
        return true
    }
}
