package racingcar.domain

import java.util.Random

class RandomMovingStrategy : MovingConditionStrategy {
    override fun move(): Int {
        return Random().nextInt(CONDITION_RANGE)
    }

    companion object {
        const val CONDITION_RANGE = 10
    }
}
