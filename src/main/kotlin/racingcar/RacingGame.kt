package racingcar

class RacingGame {
    fun play(cars: List<Car>, tryMoveCount: Int, racingGameRecorder: RacingGameRecorder) {
        repeat(tryMoveCount) {
            playEachRound(cars, racingGameRecorder)
        }
    }

    private fun playEachRound(cars: List<Car>, racingGameRecorder: RacingGameRecorder) {
        cars.forEach { car ->
            car.tryMove()
        }

        racingGameRecorder.recordRound(cars)
    }
}
