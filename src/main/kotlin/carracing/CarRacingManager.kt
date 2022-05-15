package carracing

abstract class CarRacingManager<RoleArgumentType>(
    private val carListManager: CarListManager,
    private val racingMovementRole: RacingMovementRole<RoleArgumentType>
) {

    fun tryMoveCar(carIndex: Int, argument: RoleArgumentType) {
        syncCarDistance(carIndex, getMoveDistance(carIndex, argument))
    }

    private fun getMoveDistance(carIndex: Int, argument: RoleArgumentType) =
        carListManager.getCarDistance(carIndex) + racingMovementRole.getMoveDistance(argument)

    private fun syncCarDistance(carsIndex: Int, distance: Int) {
        carListManager.moveCar(carsIndex, distance)
    }

    fun getCarSize(): Int {
        return carListManager.cars.size
    }

    fun getCarList(): List<Car> {
        return carListManager.cars
    }
}
