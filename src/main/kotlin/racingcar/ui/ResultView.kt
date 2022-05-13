package racingcar.ui

import racingcar.application.GameResult
import racingcar.application.RaceResult
import racingcar.domain.Car

object ResultView {

    private const val PADDING = 6

    fun show(gameResult: GameResult) {
        gameResult.run {
            raceResults.forEach {
                printRace(it)
            }
            printWinners(winners)
        }
    }

    private fun printRace(raceResult: RaceResult) {
        println("[${raceResult.phaseOfRace}번째 경주]")
        raceResult.raceRecord.cars.forEach { car ->
            printLane(car)
        }
        println()
    }

    private fun printLane(car: Car.State) {
        val distance = "-".repeat(car.currentPosition)
        println("${car.name.padEnd(PADDING)}: $distance")
    }

    private fun printWinners(winners: List<String>) {
        println("${winners.joinToString(", ")}가(이) 최종 우승했습니다!")
    }
}
