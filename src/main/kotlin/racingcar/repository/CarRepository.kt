package racingcar.repository

import racingcar.domain.Car

class CarRepository(
    private val cars: MutableList<Car> = mutableListOf()
) {

    fun save(car: Car) {
        cars.add(car)
    }

    fun findByName(id: Int): Car {
        return cars.findLast { it.id == id } ?: throw IllegalArgumentException("$id 에 해당하는 car가 존재하지 않습니다.")
    }

    fun findAll(): List<Car> {
        return cars.toList()
    }
}
