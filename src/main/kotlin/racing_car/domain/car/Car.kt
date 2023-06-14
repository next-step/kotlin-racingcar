package racing_car.domain.car

class Car(
    val id: String,
    private val engine: Engine,
    position: Int = 0
) {

    var position: Int = position
        private set

    val status: CarStatus get() = CarStatus(id, position)

    fun move() {
        position += engine.getMoveDistance()
    }
}

data class CarStatus(val id: String, val position: Int)
