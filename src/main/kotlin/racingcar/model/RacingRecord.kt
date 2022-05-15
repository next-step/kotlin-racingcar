package racingcar.model

data class CarRecord(val car: Car) {

    val recordForStep: List<Int>
        get() = this._recordForStep

    val latestPosition: Int
        get() = this.recordForStep.last()

    val currentStep: Int
        get() = this.recordForStep.size

    private val _recordForStep = mutableListOf<Int>()

    fun writeRecord(position: Int) {
        this._recordForStep.add(position)
    }
}

class RacingRecord(carList: Collection<Car>) {
    val carRecordList = carList.map { CarRecord(it) }
    val stepToTry: Int
        get() = carRecordList.maxOf { it.currentStep }

    val latestRecord: List<Int>
        get() = carRecordList.map { it.latestPosition }

    val winnersRecord: List<CarRecord>
        get() = this.carRecordList.filter { it.latestPosition == maxPosition }

    private val maxPosition: Int
        get() = this.carRecordList.maxOf { it.latestPosition }

    fun writeRecord(car: Car) {
        carRecordList.find { it.car.carId == car.carId }
            ?.writeRecord(car.position)
    }
}
