package com.kotlin.racingcar.step3

import step3.domain.RacingGame

fun main(args: Array<String>) {
    val racingGame = RacingGame(5, 5)

    racingGame.addRacingCar("rolroralra")
    racingGame.addRacingCar("test01")
    racingGame.addRacingCar("test02")
    racingGame.addRacingCar("test03")
    racingGame.addRacingCar("test04")

    racingGame.nextStepAll()
    racingGame.carList.forEach { println(it) }
    racingGame.historyList.forEach { println(it) }

    println("### winners")

    racingGame.getWinnerRacingCarList().forEach { println(it) }
}
