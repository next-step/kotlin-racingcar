package race

data class Names(private val values: List<Name>) : List<Name> by values {
    init {
        require(values.size == values.distinct().size) { "중복된 이름이 있습니다." }
    }

    constructor(names: String) : this(names.split(",").map(::Name))
}
