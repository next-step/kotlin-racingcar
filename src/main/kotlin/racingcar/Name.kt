package racingcar

data class Name(private val name: String) {
    constructor(index: Int) : this(index.toString())

    init {
        require(name.length <= 5)
    }

    fun stringValue() = name
}
