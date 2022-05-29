package study.racingcar.view

import study.racingcar.domain.Round

class RoundView(private val round: Round) {

    fun printRoundResult() {
        round.cars.forEach {
            println(CarView(it).result)
        }
        println()
    }

    fun printWinners() {
        val maxPosition = round.cars.maxOf { it.position }

        val winners = round.cars.filter { it.position == maxPosition }.toSet()

        println("${winners.joinToString(", ") { it.name }}$WINNER_MESSAGE")
    }

    companion object {
        private const val WINNER_MESSAGE = "가 최종 우승했습니다."
    }
}
