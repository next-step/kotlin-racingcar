package car.domain

import car.ui.NumberOfCar

class Cars(numberOfCar: NumberOfCar) {
    private val cars: List<Car>

    init {
        check(numberOfCar.value > 0) { "자동차 대수는 0보다 커야합니다." }
        cars = (0..numberOfCar.value).map { Car() }
    }

    fun move(movingStrategy: MovingStrategy) {
        cars.forEach { it.move(movingStrategy) }
    }
}
