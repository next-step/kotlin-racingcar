package racingcar.domain

class GameRound(val totalRound: Int) {

    private var progressRound: Int = 1
    private val roundResults: MutableList<GameRoundResult> = mutableListOf()

    init {
        require(totalRound in MIN_ROUND..MAX_ROUND) {
            "$MIN_ROUND ~ $MAX_ROUND 사이의 라운드만 입력할 수 있습니다."
        }
    }

    fun next(cars: List<RacingCar>) {
        cars.map { it.move() }

        val copiedCars = cars.map { it.copy() }
        val roundResult = GameRoundResult(progressRound, copiedCars)
        this.roundResults.add(roundResult)
        this.progressRound += 1
    }

    fun isFinished(): Boolean = this.totalRound < this.progressRound

    fun getResults(): List<GameRoundResult> = this.roundResults.toList()

    companion object {
        private const val MIN_ROUND = 1
        private const val MAX_ROUND = 100
    }
}
