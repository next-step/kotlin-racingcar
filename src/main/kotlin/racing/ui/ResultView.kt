package racing.ui

object ResultView {

    fun printResult() {
        println("실행 결과")
    }

    fun print(positions: List<Int>) {
        positions.forEach { position ->
            println("-".repeat(position))
        }
        println()
    }
}
