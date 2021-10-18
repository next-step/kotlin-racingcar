package racingcar.model

class RacingCarGame(
    private val gameCount: GameCount,
    private var cars: Cars,
    private val condition: RacingCarForwardCondition
) {

    fun startGame() = startGame(gameCount)

    private fun startGame(gameCount: GameCount): RacingCarGameResult {
        val snapshots = mutableListOf<RacingCarGameSnapshot>()
        repeat(gameCount) { round ->
            val snapshot = race(round + 1)
            snapshots.add(snapshot)
        }

        return RacingCarGameResult(
            gameCount = gameCount,
            snapshots = snapshots,
            winnerCars = cars.filterWinners()
        )
    }

    private fun race(round: Int): RacingCarGameSnapshot {
        this.cars = cars.move(condition)
        return RacingCarGameSnapshot(round, cars)
    }
}
