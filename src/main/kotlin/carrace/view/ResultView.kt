package carrace.view

import carrace.logic.car.Cars

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
