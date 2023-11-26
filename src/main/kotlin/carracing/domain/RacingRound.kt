package carracing.domain

data class RacingRound(
    val round: Int,
    val roundResult: List<Car>,
) {
    companion object {
        fun of(round: Int, cars: List<Car>): RacingRound {
            return RacingRound(round, cars.map { it.copy() })
        }
    }
}
