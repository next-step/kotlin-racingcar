package racing.domain

data class CarInfo(val name: Name, val position: Position) : Comparable<CarInfo> {
    constructor(name: String, position: Position) : this(Name(name), position)

    override fun compareTo(other: CarInfo): Int {
        return this.position.compareTo(other.position)
    }

    companion object {
        fun max(a: CarInfo, b: CarInfo) = if (a > b) a else b
    }
}
