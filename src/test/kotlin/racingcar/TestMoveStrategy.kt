package racingcar

class TestMoveStrategy(val value: Boolean) : MoveStrategy {
    override fun move(): Boolean {
        return value
    }
}