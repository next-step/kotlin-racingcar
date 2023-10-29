package racing.domain

data class Car(private var _location: Location? = Location()) {
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            _location = _location!!.add()
        }
    }

    val location: Int
        get() = _location!!.location!!
}
