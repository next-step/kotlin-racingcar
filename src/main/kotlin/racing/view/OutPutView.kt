package racing.view

import racing.domain.Car
import racing.domain.Cars
import racing.domain.RoundResult

object OutPutView {
    fun printStart() {
        println("\n실행 결과")
    }

    fun printRound(roundResults: Array<RoundResult>) {
        roundResults.forEach { roundResult ->
            roundResult.carNamePositions.forEach { println("${it.first} : ${makeBar(it.second)}") }
            println()
        }
    }

    private fun makeBar(position: Int): String {
        var sb = StringBuilder()
        repeat(position) {
            sb.append("-")
        }
        return sb.toString()
    }

    fun printResult(cars: Cars) {
        val winners = cars.getWinners().joinToString(separator = ", ", transform = Car::name)
        println("${winners}가 우승했습니다.")
    }
}
