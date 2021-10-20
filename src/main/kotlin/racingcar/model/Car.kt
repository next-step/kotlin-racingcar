package racingcar.model

import racingcar.exception.Exception.Companion.CASE_INCORRECT_FORMAT_NAME_OF_CAR

/**
 * 자동차 객체
 * */
data class Car(
    val name: String?,
    var movement: Int = DEFAULT_MOVEMENT
) {
    companion object {
        private const val MAX_NAME_OF_CAR = 5
        private const val MOVEMENT_FORWARD = 1
        private const val DEFAULT_MOVEMENT = 0
    }

    init {
        require(!name.isNullOrBlank()) { CASE_INCORRECT_FORMAT_NAME_OF_CAR }
        require(name.length <= MAX_NAME_OF_CAR) { CASE_INCORRECT_FORMAT_NAME_OF_CAR }
    }

    fun tryMove(isForward: Boolean): Car {
        return when (isForward) {
            true -> forward()
            false -> stop()
        }
    }

    fun forward(): Car = copy(movement = movement + MOVEMENT_FORWARD)
    fun stop(): Car = copy(movement = movement)
}
