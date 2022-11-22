package racingcar.domain

class RacingGame(
    private val initialCars: Cars,
    private val tryCount: TryCount,
) {
    private val carRecords: MutableList<Cars> = mutableListOf()

    fun getCars() = carRecords.lastOrNull() ?: Cars(emptyList())
    fun getCarRecords() = carRecords

    fun start() {
        repeat(tryCount.getCount()) {
            val cars = (carRecords.lastOrNull() ?: initialCars).race()
            carRecords.add(cars)
        }
    }
}
