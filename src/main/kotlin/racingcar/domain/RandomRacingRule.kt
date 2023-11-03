package racingcar.domain

class RandomRacingRule(
    private val random: NumberGenerator<Int>,
    private val property: MovingCondition
) : RacingRule {
    override fun canMoveForward(): Boolean = property.forwardCondition <= random.apply(property.start, property.end)
}
