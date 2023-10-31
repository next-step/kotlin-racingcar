package racing.domain

class Car(private var _location: Location = Location()) {
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            _location = _location.add()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return _location == other._location
    }

    override fun hashCode(): Int {
        return _location.hashCode()
    }

    val location: Int
        get() = _location.location
}
