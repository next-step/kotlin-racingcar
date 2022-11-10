package racingcar

import racingcar.utils.RandomNumberGenerator

class RandomMoveStrategy : MoveStrategy {
    override fun isPossibleMove(): Boolean =
        RandomNumberGenerator.generate(MIN_VALUE..MAX_VALUE) in THRESHOLD_VALUE..MAX_VALUE

    override fun getDistance(): Int = distance

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 9
        private const val THRESHOLD_VALUE = 4
        private const val distance = 1
    }
}
