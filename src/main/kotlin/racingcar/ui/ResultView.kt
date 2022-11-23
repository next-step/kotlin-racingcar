package racingcar.ui

internal class ResultView {
    init {
        println("실행 결과")
    }

    fun printCarName(name: String) {
        print("$name : ")
    }

    fun printCarMove(carMove: Int) {
        println(getMoveString(carMove))
    }

    fun printLineSpacing() {
        println()
    }

    private fun getMoveString(moveCount: Int): String = "-".repeat(moveCount)
}
