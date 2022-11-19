package racingcar.store

import racingcar.Car

object CarStore : Store<Car> {
    private var cars = listOf<Car>()

    override fun findAll(): List<Car> {
        return cars
    }

    override fun saveAll(list: List<Car>): List<Car> {
        cars = list
        return cars
    }
}
