package racingcar.model

import racingcar.exception.Exception

/**
 * 자동차 객체
 * */
data class Car(
    val name: String?,
    var movement: Int = 0
) {
    companion object {
        private const val MAX_NAME_OF_CAR = 5
        private const val MOVEMENT_FORWARD = 1
    }

    init {
        if (name.isNullOrBlank()) throw IllegalArgumentException(Exception.CASE_INCORRECT_FORMAT_NAME_OF_CAR)
        if (name.length > MAX_NAME_OF_CAR) throw IllegalArgumentException(Exception.CASE_INCORRECT_FORMAT_NAME_OF_CAR)
    }

    fun tryMove(): Car {
        return when (DriveRule().isForward()) {
            true -> forward()
            false -> stop()
        }
    }

    fun forward(): Car = copy(movement = movement + MOVEMENT_FORWARD)
    fun stop(): Car = copy(movement = movement)
}
