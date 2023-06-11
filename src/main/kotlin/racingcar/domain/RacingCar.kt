package racingcar.domain

import kotlin.random.Random

class RacingCar(
    val progress: Int = 1
) {
    fun carProgress(): RacingCar {
        if (checkCanGo { Random.nextInt(RANDOM_MAX_NUMBER) }) {
            return RacingCar(1 + progress)
        }
        return RacingCar(progress)
    }

    private fun checkCanGo(randomNumber: () -> Int): Boolean {
        return randomNumber() >= RESTRICT_NUMBER
    }

    companion object {
        private const val RANDOM_MAX_NUMBER = 10
        private const val RESTRICT_NUMBER = 4
    }
}
