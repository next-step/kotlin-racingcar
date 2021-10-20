package racingcar.model

/**
 * 자동차 객체
 * */
data class Car(
    val name: CarName,
    var movement: Int = DEFAULT_MOVEMENT
) {
    fun tryMove(isForward: Boolean): Car {
        return when (isForward) {
            true -> forward()
            false -> stop()
        }
    }

    fun forward(): Car = copy(movement = movement + MOVEMENT_FORWARD)
    fun stop(): Car = copy(movement = movement)

    companion object {
        private const val MOVEMENT_FORWARD = 1
        private const val DEFAULT_MOVEMENT = 0
    }
}
