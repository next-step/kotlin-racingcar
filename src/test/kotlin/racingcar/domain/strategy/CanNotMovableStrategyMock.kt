package racingcar.domain.strategy

class CanNotMovableStrategyMock : MovableStrategy {
    override fun move() = false
}
