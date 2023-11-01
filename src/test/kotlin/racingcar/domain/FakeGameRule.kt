package racingcar.domain

class FixedGameRule(private val direction: MovingDirection) : GameRule {
    override fun getMovingDirection(): MovingDirection = this.direction
}

class ConditionGameRule(private val predicate: (count: Int) -> Boolean) : GameRule {

    var count = 0;

    override fun getMovingDirection(): MovingDirection {
        count += 1
        return if (predicate(count)) MovingDirection.FORWARD else MovingDirection.STOP
    }
}
