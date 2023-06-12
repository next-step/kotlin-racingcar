package presentation.view

import domain.Car

class InputView {

    private var carList: List<Car> = listOf()
    private var retryCount: Int = 0

    fun getRetryCount(): Int = retryCount

    fun getCarList(): List<Car> = carList

    fun inputCarCount() {
        runCatching {
            readln().toInt()
        }.onSuccess {
            val list = mutableListOf<Car>()
            repeat(it) {
                list.add(Car())
            }
            carList = list.toList()
        }.onFailure {
            println("Error: ${it.message}")
        }
    }

    fun inputRetryRetryCount() {
        runCatching {
            readln().toInt()
        }.onSuccess {
            retryCount = it
        }.onFailure {
            println("Error: ${it.message}")
        }
    }
}
