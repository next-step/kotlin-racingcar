package racingCar.util

import kotlin.random.Random

object CarPowerGenerator : NumberGenerator {

    private const val MIN = 0
    private const val MAX = 9

    override fun generate(): Int {
        return Random.nextInt(MIN, MAX + 1)
    }
}
