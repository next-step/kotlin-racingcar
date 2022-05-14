package car_racing

abstract class CarRacingManager(carListManager: CarListManager) {
    private val _carListManager = carListManager
    val carListManager: CarListManager
        get() = _carListManager

    protected fun syncCarDistance(carsIndex: Int, distance: Int) {
        carListManager.moveCar(carsIndex, distance)
    }

    fun getCarList(): List<Car> {
        return carListManager.cars
    }
}
