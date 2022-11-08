package racingcar.condition

import racingcar.const.MoveConditionType

interface MoveCondition {
    val conditionType: MoveConditionType
    fun isAvailable(): Boolean
}
