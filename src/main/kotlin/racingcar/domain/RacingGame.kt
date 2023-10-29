package racingcar.domain

class RacingGame(
    val cars: List<RacingCar>,
    val gameRule: GameRule,
    totalRound: Int
) {

    private val gameRound = GameRound(totalRound)

    init {
        require(cars.isNotEmpty()) { "자동차는 최소 한 대 이상이어야 합니다." }
    }

    fun start() {
        cars.forEach { it.applyGameRule(gameRule) }

        while (hasNextRound()) {
            gameRound.next(cars)
        }
    }

    private fun hasNextRound() = !this.gameRound.isFinished()

    fun getRoundResults(): List<GameRoundResult> = this.gameRound.getResults()
}
