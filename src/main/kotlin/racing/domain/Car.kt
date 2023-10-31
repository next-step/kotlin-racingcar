package racing.domain

class Car(val _location: Location = Location()) {
    var location: Location = _location
        private set

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            location = location.add()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return location == other.location
    }

    override fun hashCode(): Int {
        return location.hashCode()
    }
}
