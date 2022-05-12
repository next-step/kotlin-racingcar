package racingcar

import racingcar.model.Car
import racingcar.model.GameProperties

class GameRunner(private val properties: GameProperties) {
    fun start(): GameResult {
        val cars = (1..properties.numOfCars).map { Car() }
        val recorder = GameRecorder()

        repeat(properties.numOfTrials) {
            cars.move()
            recorder.record(cars)
        }

        return recorder.gameResult
    }

    private fun List<Car>.move() = this.forEach { it.move() }
}
