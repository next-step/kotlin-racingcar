package carracing.dto

data class RacingRound(
    val round: Int,
    val roundResult: List<Car>,
) {
    companion object {
        fun of(round: Int, cars: List<Car>): RacingRound {
            val roundResult = cars.map { it.copy() }
            return RacingRound(round, roundResult)
        }
    }
}
