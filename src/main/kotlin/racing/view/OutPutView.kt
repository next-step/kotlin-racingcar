package racing.view

import racing.domain.Car
import racing.domain.GameResult
import racing.domain.RoundResult

object OutPutView {
    fun printStart() {
        println("\n실행 결과")
    }

    fun printRound(roundResults: List<RoundResult>) {
        roundResults.forEach { roundResult ->
            roundResult.value.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
            println()
        }
    }

    fun printResult(cars: List<Car>) {
        val winners = cars.joinToString(separator = ", ", transform = Car::name)
        println("${winners}가 우승했습니다.")
    }

    fun printGameResult(gameResult: GameResult) {
        printRound(gameResult.roundResults)
        printResult(gameResult.winners)
    }
}
