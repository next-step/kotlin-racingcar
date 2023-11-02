package me.parker.nextstep.kotlinracingcar.controller

import me.parker.nextstep.kotlinracingcar.RacingGame
import me.parker.nextstep.kotlinracingcar.rule.RandomRacingGameMoveRule
import me.parker.nextstep.kotlinracingcar.view.ConsoleInput
import me.parker.nextstep.kotlinracingcar.view.ConsoleResult

fun main(args: Array<String>) {
    val namesOfRacingCar: String = ConsoleInput.inputNamesOfRacingCar()
    val numOfAttempts: Int = ConsoleInput.inputNumOfAttempts()

    val racingGame = RacingGame(namesOfRacingCar, numOfAttempts, RandomRacingGameMoveRule())
    val racingGameResult = racingGame.start()

    ConsoleResult.outputGameResult(racingGameResult)
}