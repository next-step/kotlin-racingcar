package manager

import model.Car
import model.Dice

class CarManager {
    private val carList: MutableList<Car> = mutableListOf()
    private var tryCount: Int = 0

    val dice = Dice()

    fun move() {
        for (car in carList) {
            car.diceMove()
        }
    }

    fun getCarList(): List<Car> {
        return carList
    }

    fun setTryCount(tryCount: Int) {
        this.tryCount = tryCount
    }

    fun getTryCount(): Int {
        return this.tryCount
    }

    fun tryMoving() {
        repeat(tryCount) { move() }
    }

    fun addDrivers(list: List<String>) {
        for (driverName in list) {
            checkDriverName(driverName)
            carList.add(Car(dice, driverName))
        }
    }

    fun getCarWinners(): List<Car> {
        var winnerList = mutableListOf<Car>()
        var maxStepCar = carList.maxBy { it.getStep() }!!.getStep()
        for (car in carList) {
            addWinnerList(car, maxStepCar, winnerList)
        }
        return winnerList
    }

    private fun addWinnerList(car: Car, maxStepCar: Int, winnerList: MutableList<Car>) {
        if (car.getStep() == maxStepCar) {
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
