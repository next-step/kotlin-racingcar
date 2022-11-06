package game.racingcar.view

import game.racingcar.dto.RacingCarPlayResult

object OutputView {

    fun printOutputToConsole(racingCarPlayResult: RacingCarPlayResult) {
        println("실행 결과")
        racingCarPlayResult.locationSnapshots.forEach { locationOfCars ->
            locationOfCars.locations.forEach { snapshot ->
                val (name, location) = snapshot
                print("$name : ")
                repeat(location) { print("-") }
                println()
            }
            println()
        }
        val winnersString = racingCarPlayResult.winners.joinToString(", ")
        println("${winnersString}가 최종 우승했습니다.\n")
    }
}
