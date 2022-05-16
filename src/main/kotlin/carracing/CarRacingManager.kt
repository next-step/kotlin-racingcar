package carracing

abstract class CarRacingManager<MovementCheckType>(
    private val cars: Cars,
    private val racingMovementRole: RacingMovementRole<MovementCheckType>
) {

    fun tryMoveCar(carIndex: Int, argument: MovementCheckType) {
        cars.moveCar(carIndex, racingMovementRole.getMoveDistance(argument))
    }

    fun getCarSize(): Int {
        return cars.cars.size
    }

    fun getCarList(): List<Car> {
        return cars.cars
    }
}
