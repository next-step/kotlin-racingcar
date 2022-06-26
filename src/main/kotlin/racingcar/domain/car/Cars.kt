package racingcar.domain.car

class Cars(cars: List<Car>) {
    private val _cars = cars.toMutableList()

    val cars: List<Car>
        get() = _cars.toList()

    fun move() =
        _cars.forEach(Car::move)
}
