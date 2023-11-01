package me.parker.nextstep.kotlinracingcar.controller

import me.parker.nextstep.kotlinracingcar.RacingGame
import me.parker.nextstep.kotlinracingcar.rule.RandomRacingGameMoveRule
import me.parker.nextstep.kotlinracingcar.view.ConsoleInput
import me.parker.nextstep.kotlinracingcar.view.ConsoleResult

fun main(args: Array<String>) {
    val numOfRacingCar: Int = ConsoleInput.inputNumOfRacingCar()
    val numOfAttempts: Int = ConsoleInput.inputNumOfAttempts()

    val racingGame = RacingGame(numOfRacingCar, numOfAttempts, RandomRacingGameMoveRule())
    val racingCarGameRounds = racingGame.start()

    ConsoleResult.outputGameResult(racingCarGameRounds)
}