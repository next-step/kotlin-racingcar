package racingcar.domain.car

import kotlin.random.Random

class AMGEngine(private val random: Random = Random(System.currentTimeMillis())) : Engine {
    override val rpm: Int
        get() = random.nextInt(until = MAXIMUM_RPM)

    companion object {
        private const val MAXIMUM_RPM: Int = 10
    }
}
