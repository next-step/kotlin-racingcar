package racingcar.model

data class Car(
    val carName: CarName,
    val position: Int = DEFAULT_CAR_POSITION
) {

    fun tryMove(condition: RacingCarForwardCondition) = if (condition.canForward()) {
        forward()
    } else {
        backward()
    }

    private fun forward(): Car = copy(position = position + 1)

    private fun backward(): Car = copy(position = (position - 1).coerceAtLeast(0))

    companion object {
        private const val DEFAULT_CAR_POSITION = 0
    }
}
