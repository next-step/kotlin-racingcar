package carracing.service

import carracing.domain.Car
import carracing.domain.RacingCars
import carracing.domain.RacingMovementRole

abstract class CarRacingManager<MovementCheckType>(
    private val racingCars: RacingCars,
    private val racingMovementRole: RacingMovementRole<MovementCheckType>
) {

    fun tryMoveCar(carIndex: Int, argument: MovementCheckType) {
        racingCars.moveCar(carIndex, racingMovementRole.getMoveDistance(argument))
    }

    fun getWinnerCars(): List<Car> {
        return racingCars.getMaxDistanceCars()
    }

    fun getCarSize(): Int {
        return racingCars.cars.size
    }

    fun getCarList(): List<Car> {
        return racingCars.cars
    }
}
