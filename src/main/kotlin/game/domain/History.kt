package game.domain

class History(
    private var _rounds: List<Round> = listOf()
) {
    val rounds: List<Round>
        get() = _rounds

    fun addRound(cars: List<Car>) {
        var updatedRound = _rounds.toMutableList()
        updatedRound.add(Round(cars))
        _rounds = updatedRound.toList()
    }

    fun findWinners(): List<String> {
        val lastRound = _rounds.last()
        return lastRound.findWinners()
    }
}
