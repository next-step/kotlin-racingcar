package racingcar.model

class RacingCarGame(
    private val gameCount: GameCount,
    private val cars: Cars
) {

    fun startGame() = startGame(gameCount, cars)

    private fun startGame(gameCount: GameCount, cars: Cars): RacingCarGameResult {
        val snapshots = mutableListOf<RacingCarGameSnapshot>()
        repeat(gameCount) { round ->
            val snapshot = race(round + 1, cars)
            snapshots.add(snapshot)
        }

        return RacingCarGameResult(
            gameCount = gameCount,
            snapshots = snapshots.toList(),
            winnerCars = cars.filterWinners()
        )
    }

    private fun race(round: Int, cars: Cars): RacingCarGameSnapshot {
        cars.move()
        return RacingCarGameSnapshot(round, cars.toList())
    }
}
