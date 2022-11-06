package step3_racingcar.strategy

import step3_racingcar.util.extension.greaterThanOrEquals

class ForwardStrategy : MovingStrategy {
    override fun move(): Boolean {
        val randomNumber: Int = getRandomNumber()
        return randomNumber.greaterThanOrEquals(FOUR)
    }

    companion object {
        private const val FOUR = 4
    }
}
