package racingcar

import racingcar.Name.Companion.ANONYMOUS

data class Position(private val namedPosition: NamedPosition) : NamedPosition by namedPosition {

    constructor(position: Int = 0) : this(NamedPosition.Smart(ANONYMOUS, position))

    override operator fun inc() = Position(namedPosition.intValue() + 1)
}
