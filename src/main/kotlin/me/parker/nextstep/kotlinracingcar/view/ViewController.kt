package me.parker.nextstep.kotlinracingcar.view

import me.parker.nextstep.kotlinracingcar.RacingGame
import me.parker.nextstep.kotlinracingcar.rule.RandomRacingGameMoveRule

fun main(args: Array<String>) {
    val numOfRacingCar: Int = ConsoleView.inputNumOfRacingCar()
    val numOfAttempts: Int = ConsoleView.inputNumOfAttempts()

    val racingGame = RacingGame(numOfRacingCar, numOfAttempts, RandomRacingGameMoveRule())
    val racingCarGameRounds = racingGame.start()

    ConsoleView.outputResult(racingGame, racingCarGameRounds)
}