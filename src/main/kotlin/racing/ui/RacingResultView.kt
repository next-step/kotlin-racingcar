package racing.ui

import racing.application.Referee
import racing.model.Round
import racing.model.Rounds

object RacingResultView {

    fun display(tries: Int, racingResult: Rounds) {
        println("실행 결과")
        repeat(tries) { displayRound(racingResult.get(it)) }
        val finalRound = racingResult.get(tries - 1) ?: run {
            throw IllegalStateException("마지막 라운드가 치뤄지지 않았습니다")
        }
        displayWinners(finalRound)
    }

    private fun displayRound(round: Round?) {
        round?.cars
            ?.forEach { println(it) }
        println()
    }

    private fun displayWinners(finalRoundResult: Round) {
        val winners = Referee.judge(finalRoundResult)
            .joinToString(", ") { it.name }
        println("${winners}가 최종 우승했습니다.")
    }
}