package racing.ui

import racing.application.Referee
import racing.model.Car

class RacingResultView(
    private val tries: Int,
    private val eachRoundMap: Map<Int, List<Car>>
) {

    fun display() {
        println("실행 결과")
        repeat(tries) { displayRound(it) }
        displayWinners(eachRoundMap[tries-1]!!)
    }

    private fun displayRound(roundNo: Int) {
        eachRoundMap[roundNo]!!.forEach { println(it) }
        println()
    }

    private fun displayWinners(finalRoundResult: List<Car>) {
        val winners = Referee.judge(finalRoundResult)
            .joinToString(", ") { it.name }
        println("${winners}가 최종 우승했습니다.")
    }
}
