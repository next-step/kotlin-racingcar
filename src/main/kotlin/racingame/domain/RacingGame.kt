package racingame.domain

class RacingGame(
    private val cars: Cars,
    private val totalTrialCount: Int
) {
    var racingHistories: List<RacingHistory> = emptyList()
        private set

    fun run(): Winner {
        repeat(totalTrialCount) {
            cars.race()
            racingHistories = racingHistories + RacingHistory(cars.history)
        }
        return Winner(cars.history)
    }
}
