package racingcar.domain.racing

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class CarsHistory(_carsHistory: List<Cars>) {

    private val carsHistory: MutableList<Cars> = _carsHistory.toMutableList()

    val latest: Cars? get() = carsHistory.getOrNull(carsHistory.lastIndex)

    val maxDrivenCars: List<Car>
        get() {
            val maxPosition = maxPosition
            return latest?.filter { it.movedDistance == maxPosition } ?: listOf()
        }

    private val maxPosition: Int get() = latest?.maxOf { it.movedDistance } ?: 0

    constructor() : this(mutableListOf<Cars>())

    fun add(cars: Cars) {
        carsHistory.add(cars)
    }

    fun forEach(action: (Cars) -> Unit) {
        carsHistory.forEach(action)
    }
}
