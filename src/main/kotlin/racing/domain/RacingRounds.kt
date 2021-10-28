package racing.domain

@JvmInline
value class RacingRounds private constructor(private val count: Int) {
    fun raceDuringCountGivenByUser(cars: Cars, pedal: Pedal): GameResult {
        return GameResult(List(count) { cars.goForward(pedal) }, cars.getWinners())
    }

    companion object {
        fun make(count: Int): RacingRounds {
            require(count > 0) {
                "양수만 가능합니다."
            }
            return RacingRounds(count)
        }
    }
}
