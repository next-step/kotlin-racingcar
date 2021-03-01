package racingcar

data class Position(private val namedPosition: NamedPosition) : NamedPosition by namedPosition {

    constructor(position: Int) : this(NamedPosition.Smart("", position))

    override operator fun inc() = Position(namedPosition.intValue() + 1)
}
