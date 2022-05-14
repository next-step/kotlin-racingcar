package racing.ui

import racing.model.Car

class RacingResultView(
    private val tries: Int,
    private val eachRoundMap: Map<Int, List<Car>>
) {

    fun display() {
        println("실행 결과")
        repeat(tries) { displayRound(it) }
    }

    private fun displayRound(roundNo: Int) {
        eachRoundMap[roundNo]!!.forEach { println(it) }
        println()
    }
}
