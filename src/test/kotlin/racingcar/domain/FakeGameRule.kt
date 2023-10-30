package racingcar.domain

class FakeGameRule(private val direction: MovingDirection) : GameRule {
    override fun getMovingDirection(): MovingDirection = this.direction
}
