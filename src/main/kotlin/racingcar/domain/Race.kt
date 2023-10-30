package racingcar.domain

class Race(
    private val tryCount: TryCount,
    private val cars: Cars,
    private val raceResult: RaceResult
) {

    fun start() {
        repeat(tryCount.value) {
            cars.move()
            raceResult.save(cars)
        }
    }
}
