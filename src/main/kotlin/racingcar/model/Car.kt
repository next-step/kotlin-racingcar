package racingcar.model

import racingcar.DriveRule

/**
 * 자동차 객체
 * */
data class Car(
    var movement: Int = 0
) {
    fun move(random: Int): Car {
        return when (DriveRule().isForward(random)) {
            true -> forward()
            false -> stop()
        }
    }

    private fun forward(): Car = copy(movement = movement + 1)
    private fun stop(): Car = copy(movement = movement)
}
