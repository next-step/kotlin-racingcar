package carracing.view

import carracing.dto.CarDTO

object ResultView {
    fun printStartMessage() {
        println("\n실행 결과")
    }

    fun printResults(
        allRounds: List<List<CarDTO>>,
        winners: List<CarDTO>,
    ) {
        printAllRounds(allRounds)
        printWinners(winners)
    }

    private fun printWinners(winners: List<CarDTO>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }

    private fun printAllRounds(allRounds: List<List<CarDTO>>) {
        allRounds.forEach { round ->
            printCurrentRound(round)
        }
    }

    private fun printCurrentRound(round: List<CarDTO>) {
        round.forEach { carDTO ->
            println("${carDTO.name} : ${"-".repeat(carDTO.position)}")
        }
        println()
    }
}
