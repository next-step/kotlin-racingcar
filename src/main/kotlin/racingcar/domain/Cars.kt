package racingcar.domain

import kotlin.streams.toList

class Cars private constructor(carNames: String) {
    val carList = ArrayList<Car>()

    init {
        val carNamesArray = carNames.split(",")
        for (i in carNamesArray.indices) {
            carList.add(Car.makeCar(carNamesArray[i]))
        }
    }

    fun run(movingStrategy: MovingStrategy) {
        carList.forEach{ car: Car -> car.move(movingStrategy) }
    }

    fun getWinnerList():List<String> {
        val maxPosition = carList.maxOf { it.position }
        return carList.stream().filter {it.position == maxPosition}.map { car->car.name }.toList()
    }

    companion object {
        fun from(carNames: String): Cars {
            return Cars(carNames)
        }
    }
}
