package racingCar2

data class GameResult(
    val players: List<Player>
)

data class Player(
    val name: String,
    val position: Int,
)