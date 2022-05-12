package racingcar

data class Car(val position: Int = DEFAULT_POSITION) {

    fun move(): Car = Car(position + PLUS_POSITION)

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val PLUS_POSITION = 1
    }
}
