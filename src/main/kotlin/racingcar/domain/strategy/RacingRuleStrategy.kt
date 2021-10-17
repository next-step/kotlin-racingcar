package racingcar.domain.strategy

import java.util.concurrent.ThreadLocalRandom

class RacingRuleStrategy : DrivingRuleStrategy {
    override fun canDrive(carSpeed: Int): Boolean {
        return carSpeed >= DRIVING_CONDITION
    }

    companion object {
        private const val DRIVING_CONDITION = 4

        fun speedUp(): Int {
            return ThreadLocalRandom.current().nextInt(0, 9)
        }
    }
}
