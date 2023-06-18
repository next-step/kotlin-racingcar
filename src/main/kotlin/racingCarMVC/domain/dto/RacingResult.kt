package racingCarMVC.domain.dto

data class RacingResult(
    val gameResults: List<GameResult>,
    val winners: List<String>,
)