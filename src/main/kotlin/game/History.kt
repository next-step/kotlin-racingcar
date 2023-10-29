package game

class History(
    private val _rounds: MutableList<List<Car>> = mutableListOf(),
    private var _winners: List<String> = listOf()
) {
    val rounds: List<List<Car>>
        get() = _rounds.toList()
    val winners: List<String>
        get() = _winners.toList()

    fun addRound(cars: List<Car>) {
        _rounds.add(cars.map { it.copy() })
    }

    fun setWinners(findWinner: List<String>) {
        _winners = findWinner
    }
}
