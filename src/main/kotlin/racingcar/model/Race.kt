package racingcar.model

class Race(
    private val tryCount: Int,
    private val cars: Cars,
) {

    private val roundResults = RoundResults()
    private var finished: Boolean = false

    fun start() {
        repeat(tryCount) {
            cars.move()
            roundResults.save(cars)
        }
        finished = true
    }

    fun getRoundResults(): List<RoundResults.RoundResult> {
        validateRaceFinished()
        return roundResults.getRoundResults()
    }

    fun getWinners(): List<Car> {
        validateRaceFinished()
        return cars.findWinners()
    }

    private fun validateRaceFinished() {
        check(finished) {
            "아직 경기가 종료되지 않았습니다."
        }
    }
}
