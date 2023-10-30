package me.parker.nextstep.kotlinracingcar.view

import me.parker.nextstep.kotlinracingcar.RacingCar
import me.parker.nextstep.kotlinracingcar.RacingGame
import me.parker.nextstep.kotlinracingcar.rule.RandomRacingGameMoveRule

fun main(args: Array<String>) {
    println("자동차 대수는 몇 대인가요?")
    val numOfRacingCar: String = readln()

    println("시도할 횟수는 몇 회인가요?")
    val numOfAttempts: String = readln()

    val racingGame = RacingGame(
        numOfRacingCar.toInt(), numOfAttempts.toInt(),
        RandomRacingGameMoveRule()
    )
    val movedRacingCars = racingGame.start()

    println()
    println("실행 결과")
    for (attempt in 0 until numOfAttempts.toInt()) {
        printCurrentRacingCars(numOfRacingCar, movedRacingCars, attempt)

        println("==============================")
    }
    print("Result: $movedRacingCars")
}

private fun printCurrentRacingCars(
    numOfRacingCar: String,
    movedRacingCars: List<RacingCar>,
    attempt: Int
) {
    for (i in 0 until numOfRacingCar.toInt()) {
        println("-".repeat(movedRacingCars[i].moveRecords[attempt]))
    }
}