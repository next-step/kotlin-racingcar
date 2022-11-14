package racing

import racing.domain.RacingCar
import racing.model.Car

class RacingGame(
    private val racingCarGarage: RacingCarGarage,
    private val racingCar: RacingCar,
) {
    fun race(): List<Car> = racingCarGarage.cars
        .map(racingCar::driveCar)
        .let { it }
        .also(racingCarGarage::parkCars)
}
