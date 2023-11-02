package racingcar

data class Positions(val values: List<Position>) {
    constructor(vararg values: Position): this(values.toList())
}
