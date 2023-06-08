package racingcar.car

import kotlin.random.Random

class AMGEngine(private val random: Random = Random(System.currentTimeMillis())) : Engine {
    override val rpm: Int
        get() = random.nextInt(10)
}
