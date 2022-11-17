package racingcar.domain

class RacingGame(
    private val cars: Cars,
    private val tryCount: TryCount,
) {
    private val carRecords: MutableList<Cars> = mutableListOf()

    fun getCars() = cars
    fun getCarRecords() = carRecords

    fun start() {
        repeat(tryCount.getCount()) {
            cars.race()
            carRecords.add(cars)
        }
    }
}
