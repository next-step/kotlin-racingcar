package racingcar

interface NamedPosition {
    val name: Name
    fun intValue(): Int
    operator fun compareTo(other: Int): Int
    operator fun inc(): NamedPosition

    data class Smart(override val name: Name, private val position: Int = 0) : NamedPosition {
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
    }

    data class Nameless(private val position: Int = 0) : NamedPosition {
        override val name: Name
            get() {
                throw NotImplementedError()
            }

        init {
            require(position >= 0)
        }

        override fun intValue(): Int = position

        override fun compareTo(other: Int): Int = position.compareTo(other)

        override operator fun inc(): Nameless = Nameless(position + 1)
    }
}
