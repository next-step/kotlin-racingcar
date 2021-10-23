package racingcar

object ResultView {
    private const val ASK_HOW_MANY_CARS = "자동타 대수는 몇 대인가요?"
    private const val ASK_HOW_MANY_TRY = "시도할 횟수는 몇 회인가요?"
    private const val PROCESS_RESULT = "실행결과"
    private const val DIVIDER = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

    fun printResult(lapResultList: List<LapResult>) {
        println(DIVIDER)
        printLapResultList(lapResultList)
        println(DIVIDER)
    }

    private fun printLapResultList(lapResultList: List<LapResult>) {
        lapResultList.forEach {
            printLapResult(it)
        }
    }

    private fun printLapResult(lapResult: LapResult) {
        with(lapResult) {
            println("$carName : ${getMovedDistanceExpression(movedDistance)}")
        }
    }

    private fun getMovedDistanceExpression(distance: Int) = ("-".repeat(distance))

    fun printProcessResultTitle() {
        println(PROCESS_RESULT)
    }

    fun printAskHowManyCars() = println(ASK_HOW_MANY_CARS)
    fun printAskHowManyTry() = println(ASK_HOW_MANY_TRY)
}
