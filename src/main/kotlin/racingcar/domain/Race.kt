package racingcar.domain

class Race(
    private val tryCount: Int,
    private val cars: Cars,
    private val raceResult: RaceResult
) {

    fun start() {
        repeat(tryCount) {
            cars.move()
            raceResult.save(cars)
        }
    }
}
