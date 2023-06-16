package racingcar.domain.car.carengine

import kotlin.random.Random

object RandomCarEngine : CarEngine {
    private const val MIN_RANGE = 0
    private const val MAX_RANGE = 9
    private const val STANDARD_VALUE = 4

    override fun canGo() = Random.nextInt(MIN_RANGE, MAX_RANGE) >= STANDARD_VALUE
}
