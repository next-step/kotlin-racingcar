package racingcar.domain.condition

class NotMoveCondition : MoveCondition {
    override fun isAvailable(): Boolean {
        return false
    }
}
