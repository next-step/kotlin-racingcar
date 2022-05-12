package racingcar.ui

import racingcar.application.GameResult

object ResultView {

    fun show(gameResult: GameResult) {
        gameResult.raceResults.forEach {
            println("[${it.phaseOfRace}번째 경주]")
            it.raceRecord.cars.forEach { car ->
                println("-".repeat(car.currentPosition))
            }
        }
    }
}
