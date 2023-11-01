package racingcar.domain

class GameRound(val totalRound: Int) {

    private var progressRound: Int = 1

    private val _results: MutableList<GameRoundResult> = mutableListOf()
    val results: List<GameRoundResult>
        get() = this._results

    init {
        require(totalRound in MIN_ROUND..MAX_ROUND) {
            "$MIN_ROUND ~ $MAX_ROUND 사이의 라운드만 입력할 수 있습니다."
        }
    }

    fun next(cars: List<RacingCar>) {
        cars.forEach { it.move() }

        val copiedCars = cars.map { it.copy() }
        val roundResult = GameRoundResult(progressRound, copiedCars)
        this._results.add(roundResult)
        this.progressRound += 1
    }

    fun isFinished(): Boolean = this.totalRound < this.progressRound

    fun getLastRoundResult(): GameRoundResult = this._results.last()

    companion object {
        private const val MIN_ROUND = 1
        private const val MAX_ROUND = 100
    }
}
