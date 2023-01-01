package racingcar.domain

open class FixedNumberProvider(private val fixedNumber: Int = 5) : ConditionProvider {

    override fun nextCondition(): Int {
        return fixedNumber
    }
}

class AlwaysMoveConditionProvider : FixedNumberProvider(7)

class NeverMoveConditionProvider : FixedNumberProvider(1)
