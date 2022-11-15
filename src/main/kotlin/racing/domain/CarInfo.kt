package racing.domain

data class CarInfo(val name: Name, val position: Position) {
    constructor(name: String, position: Position) : this(Name(name), position)

    companion object {
        fun max(a: CarInfo, b: CarInfo) = if (a.position.max(b.position) == a.position) a else b
    }
}
