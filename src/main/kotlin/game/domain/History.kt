package game.domain

class History(
    val rounds: List<List<Car>> = listOf()
) {
    fun addRound(cars: List<Car>): History {
        var newRounds = rounds.toMutableList()
        newRounds.add(cars)
        return History(newRounds)
    }

    fun findWinners(): List<String> {
        val lastRound = rounds.last()
        val maxPosition = lastRound.maxOf { it.position }
        return lastRound.filter { it.isSamePosition(maxPosition) }.map { it.name }
    }
}
