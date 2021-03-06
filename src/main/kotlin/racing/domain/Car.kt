package racing.domain

internal class Car(name: String = "", position: Int = DEFAULT_POSITION) {

    val name: String = name.trim()
    var position: Int = position
        private set

    init {
        require(this.name.length <= MAX_NAME_LENGTH) {
            "The maximum name length is $MAX_NAME_LENGTH"
        }
    }

    fun tryMove(movable: Movable): Car {
        if (movable.isMovable()) {
            this.position++
        }

        return Car(this.name, this.position)
    }

    fun equalPosition(car: Car): Boolean {
        return this.position == car.position
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val MAX_NAME_LENGTH = 5
    }
}
