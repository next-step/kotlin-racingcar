package racingcar.domain

class Position(val name: Name = Name.Nameless(), private val position: Int = 0) : Comparable<Position> {
    val int: Int = position

    init {
        require(position >= 0)
    }

    operator fun inc(): Position = Position(name, position = position + 1)

    override fun compareTo(other: Position): Int = position.compareTo(other.position)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        return position
    }
}
