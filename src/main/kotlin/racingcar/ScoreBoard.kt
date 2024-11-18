package racingcar

class ScoreBoard(cars: List<Car>) {
    val board = mutableMapOf<String, MutableList<Int>>()
    lateinit var winners: List<String>
        private set

    init {
        require(validateCars(cars)) { "차량 목록은 비어있을 수 없습니다. 현재 전달된 차량 개수: ${cars.size}" }
        cars.forEach { board[it.name] = mutableListOf() }
    }

    fun recordPhaseResult(cars: List<Car>) {
        cars.forEach {
            board[it.name]!!.add(it.moveCount)
        }
    }

    private fun validateCars(cars: List<Car>): Boolean {
        return cars.isNotEmpty()
    }

    fun recordWinners() {
        val mostMovedDistance = board.values.maxOf { it.max() }
        winners =
            board.filter { it.value.max() == mostMovedDistance }
                .keys.toList().sorted()
    }
}
