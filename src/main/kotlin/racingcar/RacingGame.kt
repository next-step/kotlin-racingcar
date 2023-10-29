package racingcar

class RacingGame {
    fun play(cars: List<Car>, tryMoveCount: Int, racingGameRecorder: RacingGameRecorder) {
        repeat(tryMoveCount) {
            playEachRound(cars, racingGameRecorder)
        }

        selectWinners(racingGameRecorder)
    }

    private fun playEachRound(cars: List<Car>, racingGameRecorder: RacingGameRecorder) {
        cars.forEach { car ->
            car.tryMove()
        }

        racingGameRecorder.recordRound(cars)
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
