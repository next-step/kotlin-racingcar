package racing

import racing.domain.RacingCarsFactory
import racing.model.Car
import racing.model.CarCount

class RacingCarGarage(
    private val carCount: CarCount,
    private val racingCarsFactory: RacingCarsFactory,
) {
    private val _cars: MutableList<Car> by lazy {
        racingCarsFactory.createCars(carCount.value).toMutableList()
    }

    val cars: List<Car>
        get() = _cars.toList()

    fun parkCars(cars: List<Car>) {
        _cars.clear()
        _cars.addAll(cars.map { it })
    }
}
