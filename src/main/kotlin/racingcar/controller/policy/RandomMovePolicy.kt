package racingcar.controller.policy

import java.lang.Math.random

private const val THRESHOLD = 4

class RandomMovePolicy : MovePolicy {
    override fun decide(): Int {
        return if ((random() * 10).toInt() < THRESHOLD) 0 else 1
    }
}
