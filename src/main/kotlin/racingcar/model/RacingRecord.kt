package racingcar.model

class RacingRecord(numberOfCar: Int) {
    val recordList = List(numberOfCar) { mutableListOf<Int>() }
    val stepToTry: Int
        get() = recordList.maxOf { it.size }

    fun writeRecord(indexOfCar: Int, car: Car) {
        recordList[indexOfCar].add(car.position)
    }
}
