package race.view

import race.domain.Car
import race.domain.InitialTurn
import race.domain.RaceResult
import race.domain.TurnInfo

class CarRaceResultView {
    fun printRaceResult(raceResult: RaceResult) {
        println("\n실행 결과")
        raceResult.turns
            .filter { it !is InitialTurn }
            .forEach { it.print() }
        printWinners(raceResult)
    }

    private fun TurnInfo.print() {
        cars.print()
        println()
    }

    private fun List<Car>.print() {
        forEach { it.print() }
    }

    private fun Car.print() {
        println("$name : ${positionString()}")
    }

    private fun printWinners(raceResult: RaceResult) {
        println("${winnersString(raceResult)}가 최종 우승했습니다.")
    }

    private fun winnersString(raceResult: RaceResult): String {
        return raceResult.frontrunners()
            .joinToString(", ") {
                it.name
            }
    }
}
