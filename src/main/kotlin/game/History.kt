package game

class History(private val _rounds: MutableList<List<Car>> = mutableListOf()) {
    val rounds: List<List<Car>>
        get() = _rounds.toList()

    fun addRound(cars: List<Car>) {
        _rounds.add(cars.map { it.copy() })
    }
}
