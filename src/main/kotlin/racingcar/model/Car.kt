package racingcar.model

data class Car(
    val id: Int,
    val position: Int = DEFAULT_CAR_POSITION
) {

    fun forward(): Car = copy(position = position + 1)

    fun backward(): Car = copy(position = (position - 1).coerceAtLeast(0))

    companion object {
        private const val DEFAULT_CAR_POSITION = 0
    }
}
