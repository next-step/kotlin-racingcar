package racingcar

import racingcar.domain.Car
import racingcar.domain.RaceGame
import racingcar.domain.RandomNumberStrategy

fun main(args: Array<String>) {
    val input = Input()
    val result = Result()
    val raceGame = RaceGame()

    val carCount: Int = input.carCount()
    val trialCount: Int = input.trialCount()

    for (i in 1..carCount) {
        raceGame.addCar(Car())
    }

    for (i in 1..trialCount) {
        raceGame.race(RandomNumberStrategy())
        result.displayCarsResult(raceGame)
    }
}