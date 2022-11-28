package step3.racingcar.service

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.domain.RandomNumber
import step3.racingcar.view.ResultView.Companion.printRoundResult
import step3.racingcar.view.ResultView.Companion.printWinner

class RacingCarService(private val randomNumber: RandomNumber) {
    fun play(playInfo: PlayInfo) {
        repeat(playInfo.totalRound) {
            playEachRound(it, playInfo.cars)
        }
        printWinner(playInfo.cars)
    }

    fun playEachRound(currentRoundIndex: Int, cars: Cars) {
        cars.elements().forEach {
            val randomNumber = randomNumber.value()
            it.race(randomNumber)
        }
        printRoundResult(currentRoundIndex, cars)
    }

    fun playEachRoundByCar(car: Car){
        val randomNumber = randomNumber.value()
        car.race(randomNumber)
    }
}
