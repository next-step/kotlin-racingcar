package racing.view

import racing.domain.Car

internal class OutputView {

    fun renderStartMessage() {
        println("\n실행 결과")
    }

    fun renderRound(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${POSITION_CHAR.repeat(it.position)}")
        }
        println()
    }

    fun renderWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString() { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }

    companion object {
        private const val POSITION_CHAR = "-"
    }
}
