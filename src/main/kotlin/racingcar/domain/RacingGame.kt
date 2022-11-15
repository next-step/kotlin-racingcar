package racingcar.domain

class RacingGame(
    private var cars: Cars,
    private val tryCount: TryCount,
) {
    private var recordCars: MutableList<Cars> = mutableListOf()

    fun getCars() = cars
    fun getTryCount() = tryCount
    fun getRecordCars() = recordCars

    fun start() {
        repeat(tryCount.getCount()) {
            cars.race()
            recordCars.add(cars)
        }
    }
}
