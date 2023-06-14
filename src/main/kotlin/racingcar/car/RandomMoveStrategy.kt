package racingcar.car

import java.util.Random

class RandomMoveStrategy(private val random: Random): MoveStrategy {

    override val movable: Boolean
        get() = random.nextInt(MAXIMUM_MOVABLE_NUMBER) >= MINIMUM_MOVABLE_NUMBER

    companion object {
        private const val MINIMUM_MOVABLE_NUMBER = 4
        private const val MAXIMUM_MOVABLE_NUMBER = 10
    }
}
