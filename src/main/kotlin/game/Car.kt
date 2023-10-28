package game

class Car private constructor(private var position: Int = 0, val name: String) {

    fun move(moveCondition: Int) {
        when {
            canMove(moveCondition) -> advance()
        }
    }

    fun isSamePosition(position: Int) = this.position == position

    private fun advance() {
        position += 1
    }

    private fun canMove(moveCondition: Int) = moveCondition in 4..9

    fun draw(): String {
        return buildString {
            append(name)
            append(DELIMITER)
            append(POSITION_MARKER.repeat(position))
        }
    }

    fun maxPosition(position: Int): Int {
        return maxOf(position, this.position)
    }

    companion object {
        private const val POSITION_MARKER = "-"
        private const val DELIMITER = " : "

        fun of(name: String): Car {
            return Car(name = name)
        }
    }
}
