package racingcar.domain.strategy

import java.util.concurrent.ThreadLocalRandom

class RacingRuleStrategy : DrivingRuleStrategy {
    companion object {
        private const val DRIVING_CONDITION = 4

        fun speedUp(): Int {
            return ThreadLocalRandom.current().nextInt(0, 9)
        }
    }

    override fun canDrive(carSpeed: Int): Boolean {
        return carSpeed >= DRIVING_CONDITION
    }
}
