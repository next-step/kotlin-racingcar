package racingcar.view

class ResultView {
    init {
        println("실행 결과")
    }

    private fun printCarName(name: String) {
        print("$name : ")
    }

    private fun printCarMove(carMove: Int) {
        println(getMoveString(carMove))
    }

    private fun getMoveString(moveCount: Int): String = "-".repeat(moveCount)

    private fun printLineSpacing() {
        println()
    }

    fun printRacing(carNames: List<String>, moveHistory: Map<String, List<Int>>, tryCount: Int) {
        for (i in 0 until tryCount) {
            carNames.forEach { carName ->
                printCarName(carName)
                printCarMove(moveHistory[carName]!![i])
            }
            printLineSpacing()
        }
    }

    fun printWinningCars(names: List<String>) {
        print("${names.joinToString(", ")}가 최종 우승했습니다.")
    }
}
