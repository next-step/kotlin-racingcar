package racingcar.domain.strategy

interface DrivingRuleStrategy {
    fun canDrive(carSpeed: Int): Boolean
}
