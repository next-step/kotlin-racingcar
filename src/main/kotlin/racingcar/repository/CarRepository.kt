package racingcar.repository

import racingcar.domain.Car

class CarRepository(
    private val cars: MutableList<Car> = mutableListOf()
) {

    fun save(car: Car) {
        cars.removeIf { it.id == car.id }
        cars.add(car)
    }

    fun findAll(): List<Car> {
        return cars.toList()
    }
}
