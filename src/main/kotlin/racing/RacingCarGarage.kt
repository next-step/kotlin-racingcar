package racing

import racing.domain.RacingCarsFactory
import racing.model.Car
import racing.model.CarName

class RacingCarGarage(
    private val carNames: List<CarName>,
    private val racingCarsFactory: RacingCarsFactory,
) {

    private val _cars: MutableList<Car> by lazy {
        racingCarsFactory.createCars(carNames).toMutableList()
    }
    val cars: List<Car>
        get() = _cars.toList()

    fun parkCars(cars: List<Car>) {
        _cars.clear()
        _cars.addAll(cars.map { it.copy() })
    }

}
