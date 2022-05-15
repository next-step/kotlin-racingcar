package carracing

abstract class CarRacingManager<RoleArgumentType>(
    private val carListManager: CarListManager,
    private val racingMovementRole: RacingMovementRole<RoleArgumentType>
) {

    fun tryMoveCar(carIndex: Int, argument: RoleArgumentType) {
        carListManager.moveCar(carIndex, racingMovementRole.getMoveDistance(argument))
    }

    fun getCarSize(): Int {
        return carListManager.cars.size
    }

    fun getCarList(): List<Car> {
        return carListManager.cars
    }
}
