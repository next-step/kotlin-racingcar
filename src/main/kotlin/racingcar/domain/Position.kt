package racingcar.domain

data class Position(val name: Name = Name.Nameless(), private val position: Int = 0) {
    init {
        require(position >= 0)
    }

    operator fun inc(): Position = copy(position = position + 1)

    operator fun compareTo(other: Int): Int = position.compareTo(other)

    fun intValue(): Int = position
}
