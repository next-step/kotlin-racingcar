package racingCar.domain

class Race(
    private val tryCount: TryCount,
    private val cars: Cars,
    private val raceResult: RaceResult
) {

    private var _isFinished = false
    val isFinished: Boolean
        get() = _isFinished

    fun start() {
        repeat(tryCount.value) {
            cars.move()
            raceResult.save(cars)
        }
        _isFinished = true
    }
}
