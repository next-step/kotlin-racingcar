package racing.domain

class CarRacing(
    numOfCars: Int,
) {
    private val cars: List<Car> = List(numOfCars) { Car() }

    val positions: List<Int>
        get() = cars.map(Car::position)

    fun move() {
        cars.forEach(Car::move)
    }
}
