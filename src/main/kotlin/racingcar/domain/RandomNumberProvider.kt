package racingcar.domain

object RandomNumberProvider : ConditionProvider {
    override fun nextCondition(): Int {
        return (Car.MIN_BOUND..Car.MAX_BOUND).random()
    }
}
