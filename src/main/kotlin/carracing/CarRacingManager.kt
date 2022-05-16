package carracing

abstract class CarRacingManager<MovementCheckType>(
    private val racingCars: RacingCars,
    private val racingMovementRole: RacingMovementRole<MovementCheckType>
) {

    fun tryMoveCar(carIndex: Int, argument: MovementCheckType) {
        racingCars.moveCar(carIndex, racingMovementRole.getMoveDistance(argument))
    }

    fun getCarSize(): Int {
        return racingCars.cars.size
    }

    fun getCarList(): List<Car> {
        return racingCars.cars
    }
}
