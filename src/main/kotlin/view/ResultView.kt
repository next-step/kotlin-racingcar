package view

import controller.Reception
import domain.racingcar.*

object ResultView {
    fun printInt() {
        println("실행 결과")
    }

    fun printRacing(overallResult: OverallResult, cars: Cars) {
        printAllCarsPath(overallResult.overallResult)
        printWinners(cars.findWinner())
    }

    private fun printAllCarsPath(overallResult: List<Records>) {
        overallResult.forEach {
            printCarsPath(it.records)
            println()
        }
    }

    private fun printWinners(winners: Winners) {
        print(joinToWinners(winners.names, Reception.CAR_NAME_DELIMITERS) + "가 최종 우승했습니다")
    }

    fun joinToWinners(names: List<String>, delimiter: String): String {
        return names.joinToString("$delimiter ")
    }

    private fun printCarsPath(records: List<Record>) {
        records.forEach {
            printName(it.name)
            printCarPath(it.position)
        }
    }

    private fun printCarPath(position: Position) {
        println("-".repeat(position.position))
    }

    private fun printName(name: String) {
        print("$name : ")
    }
}
