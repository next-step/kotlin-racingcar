package racingcar.view

import racingcar.domain.NamedPosition

class PositionString(private val name: String, private val position: Int) {
    constructor(position: NamedPosition) : this(position.name.stringValue(), position.intValue())

    private val value: String
        get() {
            if (name.isEmpty()) {
                return positionToString()
            }
            return "$name : ${positionToString()}"
        }

    override fun toString() = value

    private fun positionToString(): String = POSITION_UNIT.repeat(position)

    companion object {
        const val POSITION_UNIT: String = "-"
    }
}
