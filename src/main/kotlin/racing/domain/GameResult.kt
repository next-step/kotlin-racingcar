package racing.domain

data class GameResult(val roundResults: List<RoundResult>, val winners: List<Car>)
