package manager

import model.Car
import model.DiceStatus

class CarManager(private val dice: DiceStatus) {
    private val carListMutable: MutableList<Car> = mutableListOf()
    val carList: List<Car>
        get() = carListMutable.toList()
    var tryCount: Int = 0

    private fun move() {
        for (car in carList) {
            car.move(dice.availableMove(dice.dice()))
        }
    }

    fun tryMoving() {
        repeat(tryCount) { move() }
    }

    fun addCarByDrivers(list: List<String>) {
        for (driverName in list) {
            checkDriverName(driverName)
            val car = Car(driverName)
            add(car)
        }
    }

    fun getCarWinners(): List<Car> {
        var winnerList = mutableListOf<Car>()
        var maxStepCar = carList.maxBy { it.step }!!.step
        for (car in carList) {
            addWinnerList(car, maxStepCar, winnerList)
        }
        return winnerList.toList()
    }

    private fun add(car: Car) {
        carListMutable.add(car)
    }

    private fun addWinnerList(car: Car, maxStepCar: Int, winnerList: MutableList<Car>) {
        if (car.step == maxStepCar) {
            winnerList.add(car)
        }
    }

    private fun checkDriverName(driverName: String) {
        if (driverName.length >= LIMIT_DRIVER_NAME_LENGTH) {
            throw IllegalArgumentException("Driver Name can't over $LIMIT_DRIVER_NAME_LENGTH")
        }
    }

    companion object {
        val LIMIT_DRIVER_NAME_LENGTH = 6
    }
}
