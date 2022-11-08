package racingcar.condition

import racingcar.const.MoveConditionType

class TestCondition : MoveCondition {
    override val conditionType: MoveConditionType = MoveConditionType.TEST
    override fun isAvailable(): Boolean {
        return true
    }
}
