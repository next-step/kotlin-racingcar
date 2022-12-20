package racingcar.view

class ResultView {
    init {
        println("실행 결과")
    }

    fun printCarName(name: String) {
        print("$name : ")
    }

    fun printCarMove(carMove: Int) {
        println(getMoveString(carMove))
    }

    fun printWinningCars(names: List<String>) {
        print("${names.joinToString(", ")}가 최종 우승했습니다.")
    }

    fun printLineSpacing() {
        println()
    }

    private fun getMoveString(moveCount: Int): String = "-".repeat(moveCount)
}
