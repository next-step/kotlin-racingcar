package racingcar.ui

import racingcar.application.GameResult
import racingcar.domain.Car

object ResultView {

    private const val PADDING = 6

    fun show(gameResult: GameResult) {
        gameResult.raceResults.forEach {
            println("[${it.phaseOfRace}번째 경주]")
            it.raceRecord.cars.forEach { car ->
                printLane(car)
            }
        }
    }

    private fun printLane(car: Car.State) {
        val distance = "-".repeat(car.currentPosition)
        println("${car.name.padEnd(PADDING)}: $distance")
    }
}
