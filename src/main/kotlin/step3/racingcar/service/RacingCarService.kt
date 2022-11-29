package step3.racingcar.service

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.domain.RandomNumber
import step3.racingcar.view.ResultView.Companion.printWinner

class RacingCarService(private val randomNumber: RandomNumber) {
    fun play(playInfo: PlayInfo) {
        repeat(playInfo.totalRound) {
            playEachRound(it, playInfo.cars)
        }
        printWinner(playInfo.cars)
    }

    fun playEachRound(currentRoundIndex: Int, cars: Cars) =
        cars.race(currentRoundIndex, randomNumber)

    fun playEachRoundByCar(car: Car) {
        val randomNumber = randomNumber.value()
        car.race(randomNumber)
    }
}
