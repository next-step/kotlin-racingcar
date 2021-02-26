package racingcar

data class Positions(private val positions: List<Position>) : List<Position> by positions {
    constructor(vararg positions: Int) : this(positions.map(::Position))

    fun add(position: Position): Positions {
        return Positions(positions + position)
    }

    operator fun plus(position: Position) = Positions(positions + position)
}
