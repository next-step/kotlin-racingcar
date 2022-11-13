package racing.domain

data class CarInfo(val name: Name, val position: Position) {
    constructor(name: String, position: Position) : this(Name(name), position)
}
