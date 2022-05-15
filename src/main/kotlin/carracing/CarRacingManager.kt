package carracing

abstract class CarRacingManager<MovementCheckType>(
    private val carList: CarList,
    private val racingMovementRole: RacingMovementRole<MovementCheckType>
) {

    fun tryMoveCar(carIndex: Int, argument: MovementCheckType) {
        carList.moveCar(carIndex, racingMovementRole.getMoveDistance(argument))
    }

    fun getCarSize(): Int {
        return carList.cars.size
    }

    fun getCarList(): List<Car> {
        return carList.cars
    }
}
