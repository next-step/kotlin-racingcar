package racingcar.model

data class CarRecord(val recordForStep: MutableList<Int> = mutableListOf())
class RacingRecord(carList: Collection<Car>) {
    val carRecordList = List(carList.size) { CarRecord() }
    val stepToTry: Int
        get() = carRecordList.maxOf { it.recordForStep.size }

    val latestRecord: List<Int>
        get() = carRecordList.map { it.recordForStep.last() }

    fun writeRecord(indexOfCar: Int, car: Car) {
        carRecordList[indexOfCar].recordForStep.add(car.position)
    }
}
