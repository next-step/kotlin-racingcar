package racing.domain

internal class Racing(
    private val racingCars: RacingCars,
    private val randomMovable: RandomMovable
) {
    val winners: List<Car>
        get() = this.racingCars.winners

    fun race(numberOfRound: Int): List<RacingCars> {
        return (0..numberOfRound).map { racingCars.nextRound(randomMovable) }
    }
}
