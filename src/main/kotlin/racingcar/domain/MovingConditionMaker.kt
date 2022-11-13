package racingcar.domain

import java.util.Random

const val CONDITION_RANGE = 10

class MovingConditionMaker {
    fun make(): Int {
        return Random().nextInt(CONDITION_RANGE)
    }
}
