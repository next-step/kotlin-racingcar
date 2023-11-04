package me.parker.nextstep.kotlinracingcar.controller

import me.parker.nextstep.kotlinracingcar.domain.RacingGame
import me.parker.nextstep.kotlinracingcar.domain.rule.RandomRacingGameMoveRule
import me.parker.nextstep.kotlinracingcar.view.ConsoleInput
import me.parker.nextstep.kotlinracingcar.view.ConsoleResult

fun main(args: Array<String>) {
    val namesOfRacingCar: String = ConsoleInput.inputNamesOfRacingCar()
    val numOfAttempts: Int = ConsoleInput.inputNumOfAttempts()

    val racingGame = RacingGame(namesOfRacingCar.split(ConsoleInput.NAME_DELIMITER),
        numOfAttempts, RandomRacingGameMoveRule()
    )
    val racingGameResult = racingGame.start()

    ConsoleResult.outputGameResult(racingGameResult)
}