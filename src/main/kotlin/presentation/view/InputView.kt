package presentation.view

import domain.Car
import domain.Race

class InputView {

    private lateinit var carList: List<Car>
    private var retryCount: Int = 0
    private lateinit var race: Race

    fun getRetryCount(): Int = retryCount

    fun getCarList(): List<Car> = carList

    fun inputCarCount() {
        val carCount = readln().toInt()
        val list = mutableListOf<Car>()
        repeat(carCount) {
            list.add(Car(it))
        }
        carList = list.toList()
    }

    fun inputRetryRetryCount() {
        retryCount = readln().toInt()
    }
}
