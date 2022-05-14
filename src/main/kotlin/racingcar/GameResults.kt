package racingcar

class GameResults {
    val gameResult
        get() = _gameResult.toList()
    private val _gameResult = mutableListOf<List<CarResult>>()

    fun record(carList: List<Car>) {
        val recordData = carList.map { CarResult(it.name, it.position) }
        _gameResult.add(recordData)
    }

    fun getWinnerResult(carList: List<Car>): List<String> {
        val winnerPosition = carList.maxOf { it.position }

        return carList
            .filter { it.position == winnerPosition }
            .map { it.name }
    }
}
