package racingcar.model

data class Car(
    val id: Int,
    val position: Int = DEFAULT_CAR_POSITION
) {

    fun forward(): Car {
        val nextPosition = position + 1
        return Car(id = id, position = nextPosition)
    }

    fun backward(): Car {
        val nextPosition = (position - 1).coerceAtLeast(0)
        return Car(id = id, position = nextPosition)
    }

    companion object {
        private const val DEFAULT_CAR_POSITION = 0
    }
}
