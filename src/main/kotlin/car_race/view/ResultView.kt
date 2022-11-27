package car_race.view

import car_race.logic.car.Cars

object ResultView {

    fun printGameResult(gameLogs: List<Cars>) {
        println("실행 결과")
        gameLogs.forEach { log ->
            log.getResult().forEach { eachResult -> println(eachResult) }
            println()
        }
        println(gameLogs.last().getWinners().getResult())
    }
}
