package racing.ui

import racing.application.Referee
import racing.model.Round

object RacingResultView {

    fun display(tries: Int, raceResult: Map<Int, Round>) {
        println("실행 결과")
        repeat(tries) { displayRound(raceResult[it]!!) }
        displayWinners(raceResult[tries-1]!!)
    }

    private fun displayRound(round: Round) {
        round.cars
            .forEach { println(it) }
        println()
    }

    private fun displayWinners(finalRound: Round) {
        val winners = Referee.judge(finalRound)
            .joinToString(", ") { it.name }
        println("${winners}가 최종 우승했습니다.")
    }
}
