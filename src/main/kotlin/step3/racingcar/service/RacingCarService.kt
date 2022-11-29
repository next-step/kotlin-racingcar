package step3.racingcar.service

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.NumberGenerator
import step3.racingcar.domain.PlayInfo
import step3.racingcar.domain.RoundResult
import step3.racingcar.domain.RoundResults

class RacingCarService(private val numberGenerator: NumberGenerator) {
    fun play(playInfo: PlayInfo): RoundResults {
        val roundResults = RoundResults.of(playInfo)
        repeat(playInfo.totalRound) {
            val playEachRoundAndReturn = playEachRound(playInfo.cars)
            roundResults.add(playEachRoundAndReturn)
        }
        return roundResults
    }

    fun playEachRound(cars: Cars): RoundResult =
        cars.raceRoundResult(numberGenerator)

    fun playEachRoundByCar(car: Car) {
        val randomNumber = numberGenerator.value()
        car.race(randomNumber)
    }
}
