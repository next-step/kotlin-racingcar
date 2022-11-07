package racing

import racing.domain.RacingCarsFactory
import racing.model.Car
import racing.model.CarCount

class RacingCarGarage(
    private val racingCarsFactory: RacingCarsFactory,
) {
    private val _cars: MutableList<Car> by lazy { mutableListOf() }
    val cars: List<Car>
        get() = _cars

    fun createCars(count: CarCount): List<Car> {
        val cars = racingCarsFactory.createCars(count.value)
        _cars.addAll(cars)
        return _cars
    }

    fun parkCars(cars: List<Car>) {
        _cars.clear()
        _cars.addAll(cars.map { it })
    }

    fun shouldCreateCars(): Boolean = cars.isEmpty()
}
