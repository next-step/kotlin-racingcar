package camp.nextstep.edu.view

import camp.nextstep.edu.model.Car

object OutputHandler {
    fun displayRoundResult(positions: List<String>) {
        positions.forEach(::println)
        println()
    }

    fun displayWinners(winners: List<Car>) {
        if (winners.isNotEmpty()) {
            val winnerNames = winners.joinToString(", ") { it.name }
            println("\n우승자: $winnerNames")
        } else {
            println("\n우승자가 없습니다.")
        }
    }
}