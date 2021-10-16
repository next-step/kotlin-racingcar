package racingcar.model

import racingcar.exception.Exception.Companion.CASE_WRONG_RANDOM_VALUE
import java.util.Random

data class Car(
    var movement: Int = 0
) {
    fun random(): Int {
        return Random().nextInt(9)
    }

    fun move(random: Int) {
        when (random) {
            in 0..3 -> stop()
            in 4..9 -> forward()
            else -> throw IllegalArgumentException(CASE_WRONG_RANDOM_VALUE)
        }
    }

    private fun forward() {
        movement += 1
    }

    private fun stop() {
        movement
    }
}
