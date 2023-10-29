package racingcar

class RacingGame {
    fun play(cars: Array<Car>, tryMoveCount: Int, moveCondition: MoveCondition, racingGameRecorder: RacingGameRecorder) {
        repeat(tryMoveCount) {
            playEachRound(cars, moveCondition, racingGameRecorder)
        }
    }

    private fun playEachRound(cars: Array<Car>, moveCondition: MoveCondition, racingGameRecorder: RacingGameRecorder) {
        cars.forEach { car ->
            car.tryMove(moveCondition)
            racingGameRecorder.record(car)
        }
    }
}
