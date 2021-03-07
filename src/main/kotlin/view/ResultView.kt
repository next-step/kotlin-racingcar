package view

import domain.racingcar.Position
import domain.racingcar.Reception
import domain.racingcar.Records
import domain.racingcar.OverallResult
import domain.racingcar.Winners

object ResultView {
    fun printInt() {
        println("실행 결과")
    }

    fun printWinners(winners: Winners) {
        print(joinToWinners(winners.names, Reception.CAR_NAME_DELIMITERS) + "가 최종 우승했습니다")
    }

    fun joinToWinners(names: List<String>, delimiter: String): String {
        return names.joinToString("$delimiter ")
    }

    fun printRacing(overallResult: OverallResult) {
        overallResult.forEach {
            printCarsPath(it)
            println()
        }
    }

    private fun printCarsPath(records: Records) {
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
