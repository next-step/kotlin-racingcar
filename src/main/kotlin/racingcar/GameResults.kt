package racingcar

class GameResults {
    val gameResult
        get() = _gameResult.toList()
    private val _gameResult = mutableListOf<List<String>>()

    fun record(carList: List<Car>) {
        val recordData = carList.map { it.makeResult() }
        _gameResult.add(recordData)
    }

    fun getWinnerResult(carList: List<Car>): String {
        val winnerPosition = carList.maxOf { it.position }
        val winnerNames = carList.filter { it.position == winnerPosition }.joinToString(", ") { it.name }
        return "$winnerNames$WINNER_POSTFIX"
    }

    companion object {
        private const val WINNER_POSTFIX = "가 최종 우승했습니다"
    }
}