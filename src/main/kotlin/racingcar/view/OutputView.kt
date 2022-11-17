package racingcar.view

class OutputView {
    private var isTitle = true

    fun showRaceState(name: String, position: String, isLastCarCycle: Boolean) {
        addTitle()
        println("$name : $position")
        addLineForLastCar(isLastCarCycle)
    }

    private fun addTitle() {
        if (isTitle) {
            println("실행 결과")
        }

        isTitle = false
    }

    private fun addLineForLastCar(isLastCarCycle: Boolean) {
        if (isLastCarCycle) {
            println()
        }
    }

    fun showWinner(winnerNames: MutableList<String>): String {
        var winnerName = ""

        for ((winnerNamesIndex, names) in winnerNames.withIndex()) {
            winnerName += makeWinnerNameFormat(winnerNamesIndex, names, winnerNames.size - 1)
        }

        println("${winnerName}가 최종 우승했습니다.")

        return winnerName
    }

    private fun makeWinnerNameFormat(winnerNamesIndex: Int, names: String, winnerNamesLastIndex: Int): String {
        if (winnerNamesIndex != winnerNamesLastIndex) {
            return "$names, "
        }
        return "$names"
    }
}
