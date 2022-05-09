package racingcar.ui

import racingcar.application.GameResult

operator fun String.times(number: Int): String {
    return List(number) { this }
        .joinToString("")
}

object ResultView {

    fun show(gameResult: GameResult) {
        gameResult.raceResults.forEach {
            println("[${it.phaseOfRace}번째 경주]")
            it.raceRecord.cars.forEach { car ->
                println("-" * car.currentPosition)
            }
        }
    }
}
