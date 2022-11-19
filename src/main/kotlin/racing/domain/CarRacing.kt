package racing.domain

class CarRacing(
    numOfCars: Int,
    moveStrategy: MoveStrategy,
) {
    private val cars: List<Car> = List(numOfCars) { Car("name", moveStrategy) }

    val positions: List<Int>
        get() = cars.map(Car::position)

    fun move() {
        cars.forEach(Car::move)
    }
}
