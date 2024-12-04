package week1.racing.domain

class RacingGameWinner {
    fun getWinners(gameRoundRecord: List<RacingCar>): List<RacingCar> {
        val maxDistance = gameRoundRecord.maxOf { it.currentPosition }
        return gameRoundRecord.filter { it.currentPosition == maxDistance }
    }
}
