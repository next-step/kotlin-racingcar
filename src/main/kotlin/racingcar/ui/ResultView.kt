package racingcar.ui

internal class ResultView {
    init {
        println("실행 결과")
    }

    fun printCarMove(carMove: Int) {
        println(getMoveString(carMove))
    }

    fun printLineSpacing() {
        println()
    }

    fun getMoveString(moveCount: Int): String = "-".repeat(moveCount)
}
