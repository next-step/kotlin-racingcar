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

    fun tryMove(movable: Movable) {
        if (movable.isMovable()) {
            this.position++
        }
    }

    fun equalPosition(car: Car): Boolean {
        return this.position == car.position
    }

    fun copy(): Car {
        return Car(this.name, this.position)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val MAX_NAME_LENGTH = 5
    }
}
