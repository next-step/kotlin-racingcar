package racing.ui

import racing.model.Rounds

class RacingResultView(
    private val tries: Int,
    private val rounds: Rounds
) {

    fun display() {
        println("실행 결과")
        repeat(tries) { displayRound(it) }
    }

    private fun displayRound(roundNo: Int) {
        rounds.get(roundNo)
            ?.cars
            ?.forEach { println(it) }
        println()
    }
}
