package racing.domain

import racing.dto.Car

class CarRacing {
    val cars: List<Car>
        get() = _cars
    private val _cars = arrayListOf<Car>()

    fun moveCars(moveCount: Int) {
        repeat(moveCount) {
            _cars.forEach(Car::go)
        }
    }

    fun createCars(carNames: List<String>) {
        _cars.clear()
        _cars.addAll(carNames.map { Car(name = it) })
    }

    fun checkCarNameLength(carName: String) {
        check(carName.length <= 5) { "차 이름은 5글자 이하여야 합니다." }
    }
}
