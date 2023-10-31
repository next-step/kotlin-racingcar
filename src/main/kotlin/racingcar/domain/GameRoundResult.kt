package racingcar.domain

data class GameRoundResult(
    val roundNumber: Int,
    val cars: List<RacingCar>
) {
    fun getRoundWinners(): List<RacingCar> {
        val maxPosition = this.cars.maxOf { it.position.value }
        return this.cars.filter { it.position.value == maxPosition }
    }
}
