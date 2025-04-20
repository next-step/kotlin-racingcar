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
            println("우승자: $winnerNames")
        } else {
            println("우승자가 없습니다.")
        }
    }

    fun displayStartMessage() {
        println("경주 시작!")
    }

    fun displayRoundStartMessage(round: Int) {
        println("$round 번째 이동")
    }

}