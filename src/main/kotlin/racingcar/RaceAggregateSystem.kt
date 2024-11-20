package racingcar

class RaceAggregateSystem(cars: List<Car>) {
    val scoreBoard: ScoreBoard
    var winners: List<String> = listOf()
        private set

    init {
        require(validateCars(cars)) { "차량 목록은 비어있을 수 없습니다. 현재 전달된 차량 개수: ${cars.size}" }
        scoreBoard = ScoreBoard(cars.map { it.name }.toList())
    }

    fun recordPhaseResult(
        nextPhase: Int,
        cars: List<Car>,
    ) {
        cars.forEach {
            scoreBoard.recordPhase(it)
        }
        if (nextPhase == 0) {
            winners = scoreBoard.calculateWinner()
        }
    }

    private fun validateCars(cars: List<Car>): Boolean {
        return cars.isNotEmpty()
    }
}
