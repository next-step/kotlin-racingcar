package racingCar.domain

class Race(
    private val tryCount: TryCount,
    private val cars: Cars,
) {

    private val raceResult: RaceResult = RaceResult()
    private var finished: Boolean = false

    fun start() {
        repeat(tryCount.value) {
            cars.move()
            raceResult.save(cars)
        }
        finished = true
    }

    fun getRoundResults(): List<RaceResult.RoundResult> {
        validateRaceFinished()
        return raceResult.getRoundResults()
    }

    fun getWinners(): List<RaceResult.CarMoveResult> {
        validateRaceFinished()
        val finalRoundResult = getFinalRoundResult()
        val maxPosition = finalRoundResult.maxOf { it.position }
        return finalRoundResult.filter { it.position == maxPosition }
    }

    private fun validateRaceFinished() {
        check(finished) {
            "아직 경기가 종료되지 않았습니다."
        }
    }

    private fun getFinalRoundResult() = raceResult.getRoundResults().sortedByDescending { it.round }[0].results
}
