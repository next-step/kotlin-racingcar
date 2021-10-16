package racingcar.model

import racingcar.exception.Exception.Companion.CASE_WRONG_RANDOM_VALUE

/**
 * 자동차 객체
 * */
data class Car(
    var movement: Int = 0
) {
    fun move(random: Int): Car {
        return when (random) {
            in 0..3 -> stop()
            in 4..9 -> forward()
            else -> throw IllegalArgumentException(CASE_WRONG_RANDOM_VALUE)
        }
    }

    private fun forward(): Car = copy(movement = movement + 1)
    private fun stop(): Car = copy(movement = movement)
}
