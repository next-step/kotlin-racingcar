package carracing

abstract class CarRacingManager(val carListManager: CarListManager) {
    protected fun syncCarDistance(carsIndex: Int, distance: Int) {
        carListManager.moveCar(carsIndex, distance)
    }

    fun getCarList(): List<Car> {
        return carListManager.cars
    }
}
