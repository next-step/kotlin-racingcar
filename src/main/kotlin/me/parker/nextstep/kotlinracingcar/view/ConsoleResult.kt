package me.parker.nextstep.kotlinracingcar.view

import me.parker.nextstep.kotlinracingcar.RacingCarGameRound

object ConsoleResult {
    fun outputGameResult(racingCarGameRounds: List<RacingCarGameRound>) {
        println()
        println("실행 결과")
        val numOfAttempts = racingCarGameRounds.size
        val numOfRacingCar = racingCarGameRounds[0].currentRacingCars.size
        for (attempt in 0 until numOfAttempts) {
            printCurrentRacingCars(numOfRacingCar, racingCarGameRounds[attempt])
            println()
        }
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