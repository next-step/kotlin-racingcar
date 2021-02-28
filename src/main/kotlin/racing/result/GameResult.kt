package racing.result

class GameResult(
    val roundResults: List<RoundResult>
)

fun List<RoundResult>.toGameResult(): GameResult {
    return GameResult(this)
}