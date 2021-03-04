package racingcar.domain

data class Positions(private val positions: List<NamedPosition>) : List<NamedPosition> by positions {
    constructor(vararg positions: Pair<String, Int>) :
        this(positions.map { (name, position) -> NamedPosition.Smart(Name(name), position) })

    fun append(position: NamedPosition) = Positions(positions + position)
}
