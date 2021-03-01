package racingcar

data class Name(private val name: String) {
    constructor(index: Int) : this(index.toString())

    fun stringValue() = name

    init {
        require(name.length <= 5)
    }
}
