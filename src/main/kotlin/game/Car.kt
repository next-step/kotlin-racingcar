package game

class Car private constructor(private var position: Int = 0, private val name: String) {

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
        return POSITION_MARKER.repeat(position)
    }

    companion object {
        private const val POSITION_MARKER = "-"

        fun of(name: String): Car {
            return Car(name = name)
        }
    }
}
