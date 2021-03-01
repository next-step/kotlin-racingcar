package racingcar

data class Name(private val name: String) {
    fun stringValue() = name

    init {
        require(name.length <= 5)
    }
}
