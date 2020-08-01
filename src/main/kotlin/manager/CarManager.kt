package manager

import model.Car
import model.DiceStatus

class CarManager(private val dice: DiceStatus) {
    private val carList: MutableList<Car> = mutableListOf()
    var tryCount: Int = 0

    private fun move() {
        for (car in carList) {
            car.move(dice.availableMove(dice.dice()))
        }
    }

    fun getCarList(): List<Car> {
        return carList
    }

    fun tryMoving() {
        repeat(tryCount) { move() }
    }

    fun addDrivers(list: List<String>) {
        for (driverName in list) {
            checkDriverName(driverName)
            carList.add(Car(driverName))
        }
    }

    fun getCarWinners(): List<Car> {
        var winnerList = mutableListOf<Car>()
        var maxStepCar = carList.maxBy { it.step }!!.step
        for (car in carList) {
            addWinnerList(car, maxStepCar, winnerList)
        }
        return winnerList
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
