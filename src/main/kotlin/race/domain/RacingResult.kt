package race.domain

data class RacingResult(val rounds: List<List<RacingCar>>) {
    fun getWinners(): List<RacingCar> {
        val racingResult = rounds.last()
        val winnerSpace = racingResult.maxOf { it.space }
        return racingResult.filter { it.space == winnerSpace }
    }
}
