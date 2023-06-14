package racingcar.view

object ResultView {
    private const val POSITION_CHARACTER = "-"

    fun init() {
        println("실행 결과")
    }

    fun printResult(positions: List<Int>) {
        positions.forEach { println(POSITION_CHARACTER.repeat(it)) }
        println()
    }
}
