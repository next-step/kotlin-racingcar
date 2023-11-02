package racingcar.domain

class RacingRule(
    private val random: NumberGenerator<Int>,
    private val validation: NameValidation,
    private val property: RacingProperty
) {
    fun canMoveForward(): Boolean = property.forwardCondition <= random.apply(property.start, property.end)
    fun nameValidate(names: List<String>): Boolean = validation.validate(names)
}
