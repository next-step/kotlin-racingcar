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
        TODO()
    }

    fun parkCars(cars: List<Car>) {
        TODO()
    }

    fun shouldCreateCars(): Boolean = TODO()
}
