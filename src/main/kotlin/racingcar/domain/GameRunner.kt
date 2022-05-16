package racingcar.domain

import racingcar.domain.model.Car
import racingcar.domain.model.GameProperties

class GameRunner(private val properties: GameProperties) {
    fun start(): GameResult {
        val cars = properties.namesOfCars.map { Car(it) }
        val recorder = GameRecorder()

        recorder.record(cars) // 시작 위치 저장

        repeat(properties.numOfTrials) {
            cars.move()
            recorder.record(cars)
        }

        return recorder.gameResult
    }

    private fun List<Car>.move() = this.forEach { it.move() }
}
