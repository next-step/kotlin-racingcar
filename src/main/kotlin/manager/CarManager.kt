package manager

import model.Car
import model.Dice

class CarManager {
    private val carList: MutableList<Car> = mutableListOf()
    private var tryCount: Int = 0
    private var carCount: Int = 0

    val dice = Dice()

    fun add() {
        carList.add(Car(dice))
    }

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

    fun setCarCount(carCount: Int) {
        this.carCount = carCount
    }

    fun getCarCount(): Int {
        return this.carCount
    }

    fun carsAdd() {
        repeat(carCount) { add() }
    }

    fun tryMoving() {
        repeat(tryCount) { move() }
    }
}
