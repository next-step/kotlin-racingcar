package racingcar

class RacingGame {
    fun play(cars: List<Car>, tryMoveCount: Int, moveCondition: MoveCondition, racingGameRecorder: RacingGameRecorder) {
        repeat(tryMoveCount) {
            playEachRound(cars, moveCondition, racingGameRecorder)
        }
    }

    private fun playEachRound(cars: List<Car>, moveCondition: MoveCondition, racingGameRecorder: RacingGameRecorder) {
        cars.forEach { car ->
            car.tryMove(moveCondition)
            racingGameRecorder.record(car)
        }
    }
}
