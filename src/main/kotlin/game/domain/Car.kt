package game.domain

class Car private constructor(val position: Int = 0, val name: String) {

    fun move(moveCondition: Int): Car {
        return when (canMove(moveCondition)) {
            true -> advance()
            false -> this
        }
    }

    fun isSamePosition(position: Int) = this.position == position

    private fun advance(): Car = Car(position + 1, name)

    private fun canMove(moveCondition: Int) = moveCondition in 4..9

    companion object {

        fun of(name: String): Car {
            return Car(name = name)
        }

        fun of(name: String, position: Int): Car {
            return Car(position, name)
        }
    }
}
