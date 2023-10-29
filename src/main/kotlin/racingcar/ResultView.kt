package racingcar

object ResultView {

    fun printPositionsHeader() {
        println("실행 결과")
    }

    fun printPositions(positions: List<Int>) {
        val progressBar = positions.joinToString(separator = "\n", postfix = "\n") { "-".repeat(it) }
        println(progressBar)
    }
}
