package racingcar

import java.util.concurrent.ThreadLocalRandom

object RandomPowerGenerator : PowerGenerator {

    private val threadLocalRandom = ThreadLocalRandom.current()

    override fun generate(): Int {
        return threadLocalRandom.nextInt(0, 10)
    }
}
