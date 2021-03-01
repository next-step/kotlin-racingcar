package racingcar

interface NamedPosition {
    val name: Name
    fun intValue(): Int

    data class Smart(override val name: Name, private val position: Int) : NamedPosition {
        init {
            require(position >= 0)
        }

        constructor(name: String, position: Int) : this(Name(name), position)

        operator fun inc(): Smart {
            return Smart(position = position + 1, name = name)
        }

        override fun intValue(): Int {
            return position
        }
    }
}
