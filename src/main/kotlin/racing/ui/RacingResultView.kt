package racing.ui

import racing.model.Round

class RacingResultView(
    private val tries: Int,
    private val eachRoundMap: Map<Int, Round>
) {

    fun display() {
        println("실행 결과")
        repeat(tries) { displayRound(it) }
    }

    private fun displayRound(roundNo: Int) {
        eachRoundMap[roundNo]?.cars?.forEach { println(it) }
        println()
    }
}
