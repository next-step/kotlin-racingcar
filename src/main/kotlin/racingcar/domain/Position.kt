package racingcar.domain

@JvmInline
value class Position(val value: Int) {
    fun forward(): Position {
        return Position(value = this.value + 1)
    }
}
