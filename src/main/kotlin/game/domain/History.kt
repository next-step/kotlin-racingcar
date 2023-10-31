package game.domain

class History(
    val rounds: List<List<Car>> = listOf(),
    val winners: List<String> = listOf()
) {
    fun addRound(cars: List<Car>): History {
        var newRounds = rounds.toMutableList()
        newRounds.add(cars.map { it.copy() })
        return History(newRounds, winners)
    }

    fun setWinners(findWinner: List<String>): History {
        return History(rounds, findWinner)
    }
}
