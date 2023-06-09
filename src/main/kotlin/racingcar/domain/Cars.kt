package racingcar.domain

class Cars(count: Int) {
    private val cars: List<Car> = List(count) { Car() }

    fun attempt() {
        for (car in cars) {
            car.go(RandomState())
        }
    }

    fun countCars() = cars.size

    val scores: List<Int>
        get() = cars.map(Car::position)
}
