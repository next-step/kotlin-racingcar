package racingcar.domain.racing

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class CarsHistory(private val carsHistory: MutableList<Cars>) : List<Cars> by carsHistory {

    val latest: Cars? get() = carsHistory.getOrNull(carsHistory.lastIndex)

    val maxDrivenCars: List<Car> get() = latest?.filter { it.movedDistance == maxPosition } ?: listOf()

    private val maxPosition: Int get() = latest?.maxOf { it.movedDistance } ?: 0

    constructor() : this(mutableListOf<Cars>())

    fun add(cars: Cars) {
        carsHistory.add(cars)
    }
}
