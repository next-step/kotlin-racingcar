package game.racingcar.view

import game.racingcar.dto.RacingCarPlayResult

object OutputView {

    fun printOutputToConsole(racingCarPlayResult: RacingCarPlayResult) {
        println("실행 결과")
        racingCarPlayResult.carLocationSnapshots.forEach { locationOfCars ->
            locationOfCars.locations.forEach { (name, location) ->
                print("$name : ")
                print("-".repeat(location))
                println()
            }
            println()
        }
        val winnersString = racingCarPlayResult.winners.joinToString(", ")
        println("${winnersString}가 최종 우승했습니다.\n")
    }
}
