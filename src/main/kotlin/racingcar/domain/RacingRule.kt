package racingcar.domain

class RacingRule(
    private val random: NumberGenerator<Int>,
    private val property: RacingProperty
) {
    fun canMoveForward(): Boolean = property.forwardCondition <= random.apply(property.start, property.end)
}
