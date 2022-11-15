package racingcar.condition

class AlwaysMoveCondition : MoveCondition {
    override fun isAvailable(): Boolean {
        return true
    }
}
