package racingcar.car.strategy

import racingcar.utils.RandomNumberGenerator

class RandomNumberStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return RandomNumberGenerator.generate() > DRIVE_DEFINE_NUMBER
    }

    companion object {
        private const val DRIVE_DEFINE_NUMBER = 4
    }
}
