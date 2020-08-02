package manager

import model.Car
import model.DiceStatus

class CarManager(private val dice: DiceStatus) {
    private val carListMutable: MutableList<Car> = mutableListOf()
    val carList: List<Car>
        get() = carListMutable.toList()
    var tryCount: Int = 0
    val winnerList: List<Car>
        get() {
            val maxStepCar = carList.maxBy { it.step }?.step ?: 0
            return carList.filter { it.isWinner(maxStepCar) }.toList()
        }
    fun tryMoving() {
        repeat(tryCount) { move() }
    }

    fun addCarByDrivers(list: List<String>) {
        for (driverName in list) {
            checkDriverName(driverName)
            val car = Car(driverName, DEFAULT_STEP, dice)
            add(car)
        }
    }

    private fun move() {
        for (car in carList) {
            car.move()
        }
    }

    private fun add(car: Car) {
        carListMutable.add(car)
    }

    private fun checkDriverName(driverName: String) {
        if (driverName.length >= LIMIT_DRIVER_NAME_LENGTH) {
            throw IllegalArgumentException("Driver Name can't over $LIMIT_DRIVER_NAME_LENGTH")
        }
    }

    companion object {
        const val LIMIT_DRIVER_NAME_LENGTH = 6
        const val DEFAULT_STEP = 0
    }
}
