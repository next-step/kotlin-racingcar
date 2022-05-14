package racingcar

data class Car(val position: Int = DEFAULT_POSITION) {

    fun move(isMove: Boolean): Car = if (isMove) Car(position + PLUS_POSITION) else this

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val PLUS_POSITION = 1
    }
}
