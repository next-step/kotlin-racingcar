package racingcar.domain

class GameResults {
    val gameHistory
        get() = _gameHistory.toList()
    private val _gameHistory = mutableListOf<List<CarResult>>()

    fun record(carList: List<Car>) {
        val recordData = carList.map { CarResult.of(it) }
        _gameHistory.add(recordData)
    }

    fun getWinnerResult(carList: List<Car>): List<String> {
        val winnerPosition = carList.maxOf { it.position }

        return carList
            .filter { it.position == winnerPosition }
            .map { it.name }
    }
}
