package me.parker.nextstep.kotlinracingcar.view

import me.parker.nextstep.kotlinracingcar.RacingCarGameRound
import me.parker.nextstep.kotlinracingcar.RacingGame

object ConsoleView {
    fun inputNumOfRacingCar(): Int {
        println("자동차 대수는 몇 대인가요?")

        return readln().toInt()
    }

    fun inputNumOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return readln().toInt()
    }

    fun outputResult(racingGame: RacingGame, racingCarGameRounds: List<RacingCarGameRound>) {
        println()
        println("실행 결과")
        for (attempt in 0 until racingGame.numOfAttempts) {
            printCurrentRacingCars(racingGame.numOfRacingCar, racingCarGameRounds[attempt])
        }
        print("Result: ${racingGame.resultOfRacingCars}")
    }

    private fun printCurrentRacingCars(
        numOfRacingCar: Int,
        racingCarGameRound: RacingCarGameRound,
    ) {
        for (i in 0 until numOfRacingCar) {
            println("-".repeat(racingCarGameRound.currentRacingCars[i].position))
        }
    }
}