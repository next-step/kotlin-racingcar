package racing.model

class RacingGameResult(
    val result: List<Cars>
) {

    fun findWinners() = result.last().findWinners()
}
