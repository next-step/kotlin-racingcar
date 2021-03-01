package racingcar

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

    private fun positionToString() = "-".repeat(position)
}
