package racingcar.strategy

import racingcar.util.extension.greaterThanOrEquals
import racingcar.util.random.RandomNumber

class ForwardStrategy(
    private val random: RandomNumber = RandomNumber(DEFAULT_RANGE)
) : MovingStrategy {
    override fun movable(): Boolean {
        val randomNumber: Int = random.generate()
        return randomNumber.greaterThanOrEquals(FOUR)
    }

    companion object {
        private val DEFAULT_RANGE = (0..9)
        private const val FOUR = 4
    }
}
