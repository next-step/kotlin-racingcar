package racingcar.model

import kotlin.random.Random.Default.nextInt

private const val MINIMUM_VALUE = 0
private const val MAXIMUM_VALUE = 9

class MoveFactor(private val value: Int) {

    init {
        require(value in (MINIMUM_VALUE..MAXIMUM_VALUE))
    }

    fun isBiggerThanOrEquals(target: Int) = value >= target

    companion object {
        fun random() = MoveFactor(nextInt(MINIMUM_VALUE, MAXIMUM_VALUE))
    }
}
