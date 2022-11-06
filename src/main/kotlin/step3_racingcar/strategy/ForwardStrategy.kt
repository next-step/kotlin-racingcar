package step3_racingcar.strategy

import step3_racingcar.util.extension.greaterThanOrEquals
import step3_racingcar.util.random.RandomNumber

class ForwardStrategy(
    private val random: RandomNumber = RandomNumber(DEFAULT_RANGE)
) : MovingStrategy {
    override fun move(): Boolean {
        val randomNumber: Int = random.generate()
        return randomNumber.greaterThanOrEquals(FOUR)
    }

    companion object {
        private val DEFAULT_RANGE = (0..9)
        private const val FOUR = 4
    }
}
