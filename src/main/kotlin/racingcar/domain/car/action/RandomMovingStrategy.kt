package racingcar.domain.car.action

private const val MOVING_MINIMUM_CONDITION_NUMBER = 4
private const val RANDOM_NUMBER_START_INDEX = 0
private const val RANDOM_NUMBER_END_INDEX = 9

class RandomMovingStrategy {
    val isMovable = MovingStrategy { (RANDOM_NUMBER_START_INDEX..RANDOM_NUMBER_END_INDEX).random() >= MOVING_MINIMUM_CONDITION_NUMBER }
}
