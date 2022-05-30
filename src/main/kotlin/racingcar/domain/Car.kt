package racingcar.domain

data class Car(val name: String, val position: Int = DEFAULT_POSITION) {

    fun move(isMove: Boolean): Car = if (isMove) {
        this.copy(position = position + PLUS_POSITION)
    } else {
        this
    }

    fun isWinner(position: Int): Boolean = this.position == position

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val PLUS_POSITION = 1
    }
}
