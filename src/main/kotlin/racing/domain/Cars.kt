package racing.domain

class Cars(
    val cars: List<Car>,
    private val moveStrategy: CarMoveStrategy
) {

    fun tryMoveCars() {
        cars.forEach {
            car -> if (moveStrategy.isMovable()) car.move()
        }
    }

    fun getCarsPosition(): List<Int> {
        return cars.map(Car::position)
    }
}
