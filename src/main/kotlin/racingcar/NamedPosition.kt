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

        constructor(name: String, position: Int) : this(Name(name), position)

        override operator fun inc(): Smart {
            return Smart(position = position + 1, name = name)
        }

        override fun intValue(): Int {
            return position
        }

        override operator fun compareTo(other: Int) = position - other
    }
}
