package racingcar

class PositionString(private val name: String, private val position: Int) {
    constructor(position: NamedPosition) : this(position.name.stringValue(), position.intValue())

    override fun toString() = value

    private val value: String
        get() {
            if (name.isEmpty()) {
                return positionToString()
            }
            return "$name : ${positionToString()}"
        }

    private fun positionToString() = "-".repeat(position)
}
