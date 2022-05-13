package racingcar.model

data class CarRecord(val car: Car, val recordForStep: MutableList<Int> = mutableListOf()) {
    val latestPosition: Int
        get() = this.recordForStep.last()
}

class RacingRecord(carList: Collection<Car>) {
    val carRecordList = carList.map { CarRecord(it) }
    val stepToTry: Int
        get() = carRecordList.maxOf { it.recordForStep.size }

    val latestRecord: List<Int>
        get() = carRecordList.map { it.recordForStep.last() }

    val winnersRecord: List<CarRecord>
        get() = this.carRecordList.filter { it.latestPosition == maxPosition }

    private val maxPosition: Int
        get() = this.carRecordList.maxOf { it.latestPosition }

    fun writeRecord(car: Car) {
        carRecordList.find { it.car.carId == car.carId }
            ?.recordForStep?.add(car.position)
    }
}
