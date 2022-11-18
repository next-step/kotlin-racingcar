package racingcar.domain.condition

class TestCondition : MoveCondition {
    override fun isAvailable(): Boolean {
        return true
    }
}
