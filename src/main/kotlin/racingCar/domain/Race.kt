package racingCar.domain

class Race(
    private val tryCount: TryCount,
    private val cars: Cars,
    private val raceResult: RaceResult
) {

    var finished: Boolean = false
        private set

    fun start() {
        repeat(tryCount.value) {
            cars.move()
            raceResult.save(cars)
        }
        finished = true
    }
}
