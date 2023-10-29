package game

class Car private constructor(private var _position: Int = 0, val name: String) {

    val position: Int
        get() = _position

    fun move(moveCondition: Int) {
        when {
            canMove(moveCondition) -> advance()
        }
    }

    fun isSamePosition(position: Int) = this._position == position

    private fun advance() {
        _position += 1
    }

    private fun canMove(moveCondition: Int) = moveCondition in 4..9

    fun draw(): String {
        return buildString {
            append(name)
            append(DELIMITER)
            append(POSITION_MARKER.repeat(_position))
        }
    }

    companion object {
        private const val POSITION_MARKER = "-"
        private const val DELIMITER = " : "

        fun of(name: String): Car {
            return Car(name = name)
        }
    }
}
