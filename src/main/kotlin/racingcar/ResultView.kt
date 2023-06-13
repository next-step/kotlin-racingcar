package racingcar

object ResultView {
    init {
        println("실행 결과")
    }

    fun showRaceResult(result: IntArray) {
        result.forEach { count ->
            repeat(count) { print("-") }
            println()
        }
        println()
    }
}
