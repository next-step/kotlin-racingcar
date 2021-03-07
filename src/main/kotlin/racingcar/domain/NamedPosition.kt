package racingcar.domain

interface NamedPosition {
    val name: Name
    fun intValue(): Int
    operator fun compareTo(other: Int): Int
    operator fun inc(): NamedPosition

    data class Smart(override val name: Name = Nameless(), private val position: Int = 0) : NamedPosition {
        init {
            require(position >= 0)
        }

        override operator fun inc(): Smart {
            return copy(position = position + 1)
        }

        override fun intValue(): Int {
            return position
        }

        override operator fun compareTo(other: Int): Int = position.compareTo(other)

        class Nameless : Name("")
    }
}
