package racing.view

private const val POSITION_CHAR = "-"

class OutputView {

    fun renderStartMessage() {
        print("실행 결과")
    }

    fun renderPositions(positions: List<Int>) {
        println()
        positions.forEach {
            println(POSITION_CHAR.repeat(it))
        }
    }
}
