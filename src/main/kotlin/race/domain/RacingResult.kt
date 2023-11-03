package race.domain

typealias RacingRound = List<RacingCar>

data class RacingResult(val rounds: List<RacingRound>) {
    fun getWinners(): List<RacingCar> {
        val racingResult = rounds.last()
        val winnerSpace = racingResult.maxOf { it.space }
        return racingResult.filter { it.space == winnerSpace }
    }
}
