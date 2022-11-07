package racingCar.domain

import java.util.Random

class RandomStrategy : MoveStrategy {

    private val random: Random = Random()

    override fun move(): Boolean = random.nextInt(MAX_BOUND_NUMBER) >= MOVE_ALLOW_NUMBER

    companion object {
        private const val MAX_BOUND_NUMBER = 10
        private const val MOVE_ALLOW_NUMBER = 4
    }
}
