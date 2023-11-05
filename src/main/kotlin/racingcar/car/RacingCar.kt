package racingcar.car

import racingcar.utils.RandomGenerator

class RacingCar(override val position: Int = 0) : Runnable {
    companion object {
        private const val RANDOM_THRESHOLD = 10
    }

    override fun run(): RacingCar {
        return RacingCar(move())
    }

    override fun getDistance(): Int {
        val randomNumber = RandomGenerator.getRandomIntNumber(RANDOM_THRESHOLD)
        return if (randomNumber >= 4) 1 else 0
    }
}
