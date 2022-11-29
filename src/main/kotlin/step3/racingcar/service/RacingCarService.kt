package step3.racingcar.service

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.domain.NumberGenerator
import step3.racingcar.view.ResultView.Companion.printWinner

class RacingCarService(private val numberGenerator: NumberGenerator) {
    fun play(playInfo: PlayInfo) {
        repeat(playInfo.totalRound) {
            playEachRound(it, playInfo.cars)
        }
        printWinner(playInfo.cars)
    }

    fun playEachRound(currentRoundIndex: Int, cars: Cars) =
        cars.race(currentRoundIndex, numberGenerator)

    fun playEachRoundByCar(car: Car) {
        val randomNumber = numberGenerator.value()
        car.race(randomNumber)
    }
}
