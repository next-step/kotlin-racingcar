package racing.model

class RacingTrack(
    private val racingCars: RacingCars,
    private val attemptCount: Int,
) {
    fun startRound(onRoundProgress: () -> Unit = {}) {
        repeat(attemptCount) {
            racingCars.moveAll()
            onRoundProgress()
        }
    }
}
