package racing.domain

class CarRacing(
    namesOfCars: List<String>,
    moveStrategy: MoveStrategy,
) {
    private val cars: List<Car> = namesOfCars.map { name -> Car(name, moveStrategy) }

    val positions: List<Int>
        get() = cars.map(Car::position)

    fun move() {
        cars.forEach(Car::move)
    }
}
