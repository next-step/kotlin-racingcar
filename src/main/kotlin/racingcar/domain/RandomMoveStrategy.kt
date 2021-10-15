package racingcar.domain

import java.util.concurrent.ThreadLocalRandom

class RandomMoveStrategy : MovingStrategy {
    override fun canMove(): Boolean {
        val randomNumber = ThreadLocalRandom.current().nextInt(0, 9)
        return randomNumber > MINIMUM_MOVE_NUMBER
    }

    companion object {
        private const val MINIMUM_MOVE_NUMBER = 4
    }
}
