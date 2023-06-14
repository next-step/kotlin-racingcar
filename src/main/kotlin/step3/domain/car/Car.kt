package step3.domain.car

class Car(
    val id: Int,
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

data class CarStatus(val id: Int, val position: Int)
