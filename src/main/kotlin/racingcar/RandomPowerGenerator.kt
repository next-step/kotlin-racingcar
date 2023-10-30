package racingcar

import kotlin.random.Random

object RandomPowerGenerator : PowerGenerator {

    private const val MAX_POWER = 10
    private const val MIN_POWER = 0


    override fun generate(): Int {
        return Random.nextInt(MIN_POWER, MAX_POWER)
    }
}
