package racingcar.domain

class FixedNumberProvider(private val fixedNumber: Int = 5) : ConditionProvider {

    override fun nextCondition(): Int {
        return fixedNumber
    }
}
