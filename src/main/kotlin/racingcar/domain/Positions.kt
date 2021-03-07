package racingcar.domain

data class Positions(private val positions: List<Position>) : List<Position> by positions {
    constructor(vararg positions: Pair<String, Int>) :
        this(positions.map { (name, position) -> Position(Name(name), position) })

    fun append(position: Position) = Positions(positions + position)
}
