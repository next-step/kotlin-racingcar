package racingcar.model

import racingcar.exception.Exception.Companion.CASE_WRONG_RANDOM_VALUE
import java.util.Random

/**
 * 자동차 객체
 * */
data class Car(
    var movement: Int = 0
) {
    fun random(): Int {
        return Random().nextInt(9)
    }

    fun forward(): Car = copy(movement = movement + 1)
    fun stop(): Car = copy(movement = movement)
}

fun Car.move(random: Int): Car {
    return when (random) {
        in 0..3 -> stop()
        in 4..9 -> forward()
        else -> throw IllegalArgumentException(CASE_WRONG_RANDOM_VALUE)
    }
}
