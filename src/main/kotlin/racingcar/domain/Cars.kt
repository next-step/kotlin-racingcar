package racingcar.domain

class Cars(count: Int) {
    private val cars: List<Car> = List(count) { Car() }

    fun attempt(moveCondition: MoveCondition) {
        for (car in cars) {
            car.go(moveCondition)
        }
    }

    fun countCars() = cars.size

    val positions: List<Int>
        get() = cars.map(Car::position)
}
