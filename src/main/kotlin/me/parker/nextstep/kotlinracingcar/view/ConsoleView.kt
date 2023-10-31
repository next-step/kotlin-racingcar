package me.parker.nextstep.kotlinracingcar.view

import me.parker.nextstep.kotlinracingcar.RacingCar

object ConsoleView {
    fun inputNumOfRacingCar(): Int {
        println("자동차 대수는 몇 대인가요?")

        return readln().toInt()
    }

    fun inputNumOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return readln().toInt()
    }

    fun outputResult(numOfRacingCar: Int, numOfAttempts: Int, movedRacingCars: List<RacingCar>) {
        println()
        println("실행 결과")
        for (attempt in 0 until numOfAttempts) {
            printCurrentRacingCars(numOfRacingCar, movedRacingCars, attempt)

            println("==============================")
        }
        print("Result: $movedRacingCars")
    }

    private fun printCurrentRacingCars(
        numOfRacingCar: Int,
        movedRacingCars: List<RacingCar>,
        attempt: Int
    ) {
        for (i in 0 until numOfRacingCar) {
            println("-".repeat(movedRacingCars[i].moveRecords[attempt]))
        }
    }
}