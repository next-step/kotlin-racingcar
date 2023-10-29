package racingcar

import java.util.concurrent.ThreadLocalRandom

object RandomPowerGenerator : PowerGenerator {

    private const val MAX_POWER = 10
    private const val MIN_POWER = 0

    private val threadLocalRandom = ThreadLocalRandom.current()

    override fun generate(): Int {
        return threadLocalRandom.nextInt(MIN_POWER, MAX_POWER)
    }
}
