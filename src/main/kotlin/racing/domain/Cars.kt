package racing.domain

class Cars(
    val cars: List<Car>,
    private val moveStrategy: CarMoveStrategy
) {

    fun tryMoveCars() {
        cars.forEach {
            car ->
            if (moveStrategy.isMovable()) car.move()
        }
    }

    fun winner(): List<Car> {
        val maxPosition = cars.maxOf { it.position.value }
        return cars.filter { it.position.value == maxPosition }
    }
}
