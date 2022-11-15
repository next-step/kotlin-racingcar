package racing.domain

data class CarInfo(val name: Name, val position: Position) {
    constructor(name: String, position: Position) : this(Name(name), position)

    fun max(other: CarInfo) = if (this.position.max(other.position) == this.position) this else other
}
