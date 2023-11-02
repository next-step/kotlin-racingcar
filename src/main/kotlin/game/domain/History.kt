package game.domain

class History(
    val rounds: List<List<Car>> = listOf()
) {
    fun addRound(cars: List<Car>): History {
        var newRounds = rounds.toMutableList()
        newRounds.add(cars)
        return History(newRounds)
    }
}
