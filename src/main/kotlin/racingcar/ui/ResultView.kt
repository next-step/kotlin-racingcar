package racingcar.ui

import racingcar.application.GameResult
import racingcar.domain.Car
import racingcar.domain.Record

object ResultView {

    private const val PADDING = 6

    fun show(gameResult: GameResult) {

        gameResult.records.forEachIndexed { i, record ->
            printRace(i + 1, record)
        }
        printWinners(gameResult.winners)
    }

    private fun printRace(roundOfRace: Int, record: Record) {
        println("[${roundOfRace}번째 경주]")
        record.carStates.forEach { car ->
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
