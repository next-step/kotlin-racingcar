package step3.domain.car.action

import step3.util.Utils

private const val MOVING_MINIMUM_CONDITION_NUMBER = 4

class MovingStrategyImpl : MovingStrategy {
    override fun isMovable(): Boolean {
        if (MOVING_MINIMUM_CONDITION_NUMBER <= Utils.generateRandomNumber(Utils.RANDOM_NUMBER_START_INDEX, Utils.RANDOM_NUMBER_END_INDEX)) {
            return true
        }
        return false
    }
}
