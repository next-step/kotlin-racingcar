package racingcar.model

data class Car(val position: Int = DEFAULT_CAR_POSITION) {

    fun forward(): Car {
        val nextPosition = position + 1
        return Car(position = nextPosition)
    }

    fun backward(): Car {
        val nextPosition = (position - 1).coerceAtLeast(0)
        return Car(position = nextPosition)
    }

    companion object {
        private const val DEFAULT_CAR_POSITION = 0
    }
}
