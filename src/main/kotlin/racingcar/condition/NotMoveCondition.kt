package racingcar.condition

class NotMoveCondition : MoveCondition {
    override fun isAvailable(): Boolean {
        return false
    }
}
