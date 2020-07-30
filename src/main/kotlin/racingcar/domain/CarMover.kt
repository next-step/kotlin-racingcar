package racingcar.domain

import kotlin.random.Random
import kotlin.random.nextInt

class CarMover : Mover {

    override fun canMove(): Boolean {
        return Random.nextInt(0..MAX_RANDOM_NUM) >= CONDITION_CAN_MOVE
    }

    companion object {
        private const val MAX_RANDOM_NUM = 9
        private const val CONDITION_CAN_MOVE = 4
    }
}
