package racingcar.domain.car

import kotlin.random.Random

class RacingCarEngine : Engine {
    override fun power(): Int {
        return Random.nextInt(MAXIMUM_POWER_NUMBER) + 1
    }

    companion object {
        const val MAXIMUM_POWER_NUMBER = 9
    }
}
