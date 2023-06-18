package racingCarMVC.domain.dto

data class GameResult(
    val gameRecord: List<GameRecord>
)

data class GameRecord(
    val name: String,
    val position: Int,
)
