package racingcar.controller

object RandomNumberProvider : ConditionProvider {
    override fun nextCondition(): Int {
        return (0..9).random()
    }
}
