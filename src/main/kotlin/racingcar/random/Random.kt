package racingcar.random

object Random {
    private val RANDOM_BOUND = 1..10
    private const val MINIMUM_VALUE = 3

    fun randomForward(): Int {
        return if (RANDOM_BOUND.random() > MINIMUM_VALUE) 1 else 0
    }
}
