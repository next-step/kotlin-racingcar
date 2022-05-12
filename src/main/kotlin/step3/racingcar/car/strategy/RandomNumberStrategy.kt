package step3.racingcar.car.strategy

import step3.racingcar.RandomNumberGenerator

class RandomNumberStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return RandomNumberGenerator.generate() > DRIVE_DEFINE_NUMBER
    }

    companion object {
        private const val DRIVE_DEFINE_NUMBER = 4
    }
}
