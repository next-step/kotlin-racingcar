package racingcar.domain.racing

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class CarsHistory(carsHistory: List<Cars> = emptyList()) {

    private val _carsHistory: MutableList<Cars> = carsHistory.toMutableList()
    val carsHistory: List<Cars> get() = _carsHistory

    val latest: Cars? get() = carsHistory.lastOrNull()

    val maxDrivenCars: List<Car>
        get() {
            val maxPosition = maxPosition
            return latest?.filter { it.movedDistance == maxPosition } ?: emptyList()
        }

    private val maxPosition: Int get() = latest?.maxOf { it.movedDistance } ?: 0

    fun add(cars: Cars) {
        _carsHistory.add(cars)
    }
}
