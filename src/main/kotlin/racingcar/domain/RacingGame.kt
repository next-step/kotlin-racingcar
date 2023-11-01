package racingcar.domain

class RacingGame {
    fun play(cars: List<Car>, tryMoveCount: Int, racingGameRecorder: RacingGameRecorder) {
        (0 until tryMoveCount).fold(cars) { acc, _ ->
            val movedCars = playEachRound(acc)

            racingGameRecorder.recordRound(movedCars)

            movedCars
        }
    }

    private fun playEachRound(cars: List<Car>): List<Car> {
        return cars.map { car ->
            car.tryMove()
        }
    }
}
