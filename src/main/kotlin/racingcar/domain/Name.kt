package racingcar.domain

open class Name(private val name: String) {
    init {
        require(name.length <= 5)
    }

    constructor(index: Int) : this(index.toString())

    fun stringValue() = name

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Name

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    class Nameless : Name("")
}
