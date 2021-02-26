package racingcar

data class Position(private val position: Int) {
    init {
        require(position >= 0)
    }

    fun increase() = copy(position = position + 1)

    fun intValue() = position
}
