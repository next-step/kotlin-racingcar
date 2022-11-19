package racingcar.store

import racingcar.Car

object CarStore : Store<List<Car>> {
    private var cars = listOf<Car>()

    override fun getState(): List<Car> {
        return cars
    }

    override fun setState(state: List<Car>): List<Car> {
        cars = state
        return cars
    }
}
