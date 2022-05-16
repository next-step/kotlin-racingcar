package racing.model

class RacingGameResult(
    val result: List<Cars>
) {

    fun findWinners(): List<Car> {
        return result.last().findWinners()
    }
}
