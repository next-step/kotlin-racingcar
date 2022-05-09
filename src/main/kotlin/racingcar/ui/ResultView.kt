package racingcar.ui

import racingcar.application.GameResult

operator fun String.times(number: Int): String {
    return List(number) { this }
        .joinToString("")
}

object ResultView {

    fun show(gameResult: GameResult) {
        gameResult.racingGameRecords.run {
            forEach {
                println("[${it.phaseOfRace}번째 진행]")
                it.raceRecord.forEach { car ->
                    println("-" * car.currentPosition)
                }
            }
        }
    }
}
