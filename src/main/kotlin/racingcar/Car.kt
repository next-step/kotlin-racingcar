package racingcar

data class Car(val name: String, val position: Int = DEFAULT_POSITION) {

    fun move(isMove: Boolean): Car = if (isMove) Car(this.name, position + PLUS_POSITION) else this

    fun isWinner(position: Int) = this.position == position

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val PLUS_POSITION = 1
    }
}
