package racingcar.domain.racing

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class CarsHistory(private val carsHistory: MutableList<Cars>) : List<Cars> by carsHistory {

    val latest: Cars? get() = carsHistory[0]

    val maxDrivenCars: List<Car> get() = listOf()

    private val maxPosition: Int get() = 0

    constructor() : this(mutableListOf<Cars>())

    fun add(cars: Cars) {
    }
}
