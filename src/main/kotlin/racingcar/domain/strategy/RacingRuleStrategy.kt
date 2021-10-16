package racingcar.domain.strategy

class RacingRuleStrategy : DrivingRuleStrategy {
    companion object {
        private const val DRIVING_CONDITION = 4
    }

    override fun canDrive(carSpeed: Int): Boolean {
        return carSpeed >= DRIVING_CONDITION
    }
}
