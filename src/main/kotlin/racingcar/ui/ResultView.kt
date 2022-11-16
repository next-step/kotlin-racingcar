package racingcar.ui

internal class ResultView {
    fun printInitResult() {
        println("실행 결과")
    }

    fun printCarMoveCount(moveCount: Int) {
        println(getMoveString(moveCount))
    }

    fun printLineSpacing() {
        println()
    }

    fun getMoveString(moveCount: Int): String =
        StringBuilder().apply {
            for (i in 0 until moveCount) {
                append("-")
            }
        }.toString()
}
