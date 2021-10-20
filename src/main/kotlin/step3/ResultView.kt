package step3

object ResultView {
    private const val PROCESS_RESULT = "실행결과"
    private const val DIVIDER = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

    fun printResult(distanceList: List<Int>) {
        println(DIVIDER)
        distanceList.forEach {
            printMovedDistance(it)
        }
        println(DIVIDER)
    }

    private fun printMovedDistance(distance: Int) {
        println("-".repeat(distance))
    }

    fun printProcessResultTitle() {
        println(PROCESS_RESULT)
    }
}
