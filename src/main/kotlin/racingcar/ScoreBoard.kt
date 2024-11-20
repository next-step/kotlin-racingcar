package racingcar

class ScoreBoard(carNames: List<String>) {
    val board = mutableMapOf<String, PhaseResultRow>()

    init {
        require(carNames.isNotEmpty()) { "자동차 이름의 목록은 비어있을 수 없습니다." }
        carNames.forEach { board[it] = PhaseResultRow() }
    }

    fun recordPhase(car: Car) {
        board.computeIfAbsent(car.name) { PhaseResultRow() }
            .addResult(car.moveCount)
    }

    fun calculateWinner(): List<String> {
        val maxDistance = getMaxDistance()
        return board.filter { it.value.getMax() == maxDistance }.keys.toList().sorted()
    }

    private fun getMaxDistance(): Int {
        return board.values.maxOf { it.getMax() }
    }
}
