package racing.domain

internal class Racing(
    private val racingCars: RacingCars,
    private val randomMovable: RandomMovable
) {
    val cars: List<Car>
        get() = this.racingCars.cars

    val winners: List<Car>
        get() = this.racingCars.winners

    fun nextRound() {
        racingCars.nextRound(this.randomMovable)
    }
}
