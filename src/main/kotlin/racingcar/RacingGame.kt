package racingcar

class RacingGame {
    fun play(cars: List<Car>, tryMoveCount: Int, racingGameRecorder: RacingGameRecorder) {
        (0 until tryMoveCount).fold(cars) { acc, _ ->
            val movedCars = playEachRound(acc)

            racingGameRecorder.recordRound(movedCars)

            movedCars
        }

        selectWinners(racingGameRecorder)
    }

    private fun playEachRound(cars: List<Car>): List<Car> {
        val movedCars = cars.map { car ->
            car.tryMove()
        }

        return movedCars
    }

    private fun selectWinners(racingGameRecorder: RacingGameRecorder) {
        val finalRaceResult = racingGameRecorder.gameResultRecord
            .finalRaceResult
            ?: return

        val maxDistance = finalRaceResult.carPositions
            .maxOfOrNull { it.position }

        val winnersName = finalRaceResult.carPositions
            .filter { it.position == maxDistance }
            .map { it.name }

        racingGameRecorder.recordWinners(winnersName)
    }
}
