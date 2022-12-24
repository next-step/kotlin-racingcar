package racingcar.view

import racingcar.data.CarMoves

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

    fun printRacing(carHistory: List<CarMoves>, tryCount: Int) {
        for (i in 0 until tryCount) {
            carHistory.forEach { carMoves ->
                printCarName(carMoves.carName)
                printCarMove(carMoves.moves[i])
            }
            printLineSpacing()
        }
    }

    fun printWinningCars(names: List<String>) {
        print("${names.joinToString(", ")}가 최종 우승했습니다.")
    }
}
