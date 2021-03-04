package racingcar.domain

inline class Name(private val name: String) {
    init {
        require(name.length <= 5)
    }

    constructor(index: Int) : this(index.toString())

    fun stringValue() = name
}
