package racingcar.domain.car.action

import racingcar.util.Utils

private const val MOVING_MINIMUM_CONDITION_NUMBER = 4

class RandomMovingStrategy : MovingStrategy {
    override fun isMovable(): Boolean {
        if (MOVING_MINIMUM_CONDITION_NUMBER <= Utils.generateRandomNumber(Utils.RANDOM_NUMBER_START_INDEX, Utils.RANDOM_NUMBER_END_INDEX)) {
            return true
        }
        return false
    }
}
