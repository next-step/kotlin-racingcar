package racing.domain

internal class Racing(
    private val racingCars: RacingCars,
    private val movable: Movable
) {
    fun race(numberOfRound: Int): RacingResult {
        val history = mutableListOf<List<Car>>()
        repeat(numberOfRound) {
            racingCars.nextRound(movable)
            history.add(racingCars.copyCars())
        }

        return RacingResult(carsHistories = history, winners = this.racingCars.winners)
    }
}
