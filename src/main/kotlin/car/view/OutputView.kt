package car.view

import car.domain.CarRacingGameResult
import car.domain.MovedCar
import car.domain.RoundResult

class OutputView {
    fun printResult(result: CarRacingGameResult) {
        println("실행 결과")
        result.value.forEach { printRoundResult(it) }
        printWinners(result.winners)
    }

    private fun printRoundResult(roundResult: RoundResult) {
        roundResult.value.forEach { movedCarPosition(it) }
        println()
    }

    private fun movedCarPosition(movedCar: MovedCar) {
        val positionMark = (1..movedCar.position)
            .joinToString("") { "-" }
        println("${movedCar.name} : $positionMark")
    }

    private fun printWinners(winners: List<String>) {
        val winners = winners.joinToString(", ")
        println("${winners}가 최종 우승했습니다.")
    }
}