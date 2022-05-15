package carracing

abstract class CarRacingManager<MovementCheckType>(
    private val carListManager: CarListManager,
    private val racingMovementRole: RacingMovementRole<MovementCheckType>
) {

    fun tryMoveCar(carIndex: Int, argument: MovementCheckType) {
        carListManager.moveCar(carIndex, racingMovementRole.getMoveDistance(argument))
    }

    fun getCarSize(): Int {
        return carListManager.cars.size
    }

    fun getCarList(): List<Car> {
        return carListManager.cars
    }
}
