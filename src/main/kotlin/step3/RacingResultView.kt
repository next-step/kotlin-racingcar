package step3

class RacingResultView(
    private val tries: Int,
    private val eachRoundMap: Map<Int, List<Car>>
) {

    fun display() {
        repeat(tries) { displayRound(it) }
    }

    private fun displayRound(roundNo: Int) {
        eachRoundMap[roundNo]!!.forEach { println(it) }
        println()
    }
}