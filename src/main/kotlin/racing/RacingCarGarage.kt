package racing

import racing.domain.RacingCarsFactory
import racing.model.Car
import racing.model.Driver

class RacingCarGarage(
    private val racingCarsFactory: RacingCarsFactory,
) {

    private val _cars: MutableList<Car> = mutableListOf()
    val cars: List<Car>
        get() = _cars.toList()

    fun setCarsWithDrivers(drivers: List<Driver>) {
        racingCarsFactory.createCars(drivers)
            .also {
                _cars.addAll(it)
            }
    }

    fun parkCars(cars: List<Car>) {
        _cars.clear()
        _cars.addAll(cars.map { it.copy() })
    }

}
