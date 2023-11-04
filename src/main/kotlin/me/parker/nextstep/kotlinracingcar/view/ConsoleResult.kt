package me.parker.nextstep.kotlinracingcar.view

import me.parker.nextstep.kotlinracingcar.domain.RacingCarGameRound
import me.parker.nextstep.kotlinracingcar.domain.RacingGameResult

object ConsoleResult {
    fun outputGameResult(racingGameResult: RacingGameResult) {
        println()
        println("실행 결과")
        val rounds = racingGameResult.rounds
        val numOfAttempts = rounds.size
        val numOfRacingCar = rounds[0].currentRacingCars.size
        for (attempt in 0 until numOfAttempts) {
            printCurrentRacingCars(numOfRacingCar, rounds[attempt])
            println()
        }

        val winners = racingGameResult.winners
        println("${winners.racingCars.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    private fun printCurrentRacingCars(
        numOfRacingCar: Int,
        racingCarGameRound: RacingCarGameRound,
    ) {
        for (i in 0 until numOfRacingCar) {
            val currentRacingCar = racingCarGameRound.currentRacingCars[i]
            print(currentRacingCar.name + " : ")
            println("-".repeat(currentRacingCar.position))
        }
    }
}