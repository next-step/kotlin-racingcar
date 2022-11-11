package racingcar

import kotlin.random.Random

private const val MIN_POWER = 0
private const val MAX_POWER_EXCLUSIVE = 10

class RandomCarControl : CarControl {
    override fun power(): Int {
        return Random.nextInt(MIN_POWER, MAX_POWER_EXCLUSIVE)
    }
}
