package racingcar

data class Positions(private val positions: List<Position>) : List<Position> by positions {
    constructor(vararg positions: Int) : this(positions.map(::Position))

    operator fun plus(position: Position) = Positions(positions + position)
}
