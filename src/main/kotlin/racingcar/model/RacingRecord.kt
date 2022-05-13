package racingcar.model

data class CarRecord(val carId: String, val recordForStep: MutableList<Int> = mutableListOf())
class RacingRecord(carList: Collection<Car>) {
    val carRecordList = carList.map { CarRecord(it.carId) }
    val stepToTry: Int
        get() = carRecordList.maxOf { it.recordForStep.size }

    val latestRecord: List<Int>
        get() = carRecordList.map { it.recordForStep.last() }

    fun writeRecord(car: Car) {
        carRecordList.find { it.carId == car.carId }
            ?.recordForStep?.add(car.position)
    }
}
