package racingcar.model

class RacingCarGame(
    private val gameCount: GameCount,
    private val initialCars: Cars,
    private val condition: RacingCarForwardCondition
) {

    fun startGame() = startGame(gameCount, initialCars)

    private fun startGame(gameCount: GameCount, initialCars: Cars): RacingCarGameResult {
        val snapshots = mutableListOf<RacingCarGameSnapshot>()
        var cars = initialCars

        race(gameCount) { round ->
            cars = cars.move(condition)
            snapshots += createSnapshot(round, cars)
        }

        return RacingCarGameResult(
            gameCount = gameCount,
            snapshots = snapshots,
            winnerCars = cars.filterWinners()
        )
    }

    private inline fun race(
        gameCount: GameCount,
        action: (round: Int) -> Unit
    ) = repeat(gameCount) { round -> action(round + 1) }

    private fun createSnapshot(round: Int, cars: Cars) = RacingCarGameSnapshot(round, cars)
}
