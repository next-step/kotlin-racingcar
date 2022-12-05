package racingcar.view

class OutputView {
    private var isTitle = true
    private var turnOfCar = 0

    fun showRaceState(name: String, position: Int, numberOfCars: Int) {
        addTitle()
        print("$name : ")
        for (i in 0 until position) {
            print("$MOVE_MARKER")
        }
        println()
        turnOfCar++
        addLineForLastCar(turnOfCar == numberOfCars)
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
            turnOfCar = 0
        }
    }

    fun showWinner(winners: List<String>): String {
        var winnerName = ""

        for ((index, name) in winners.withIndex()) {
            winnerName += makeWinnerNameFormat(index, name, winners.size - 1)
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

    companion object {
        const val MOVE_MARKER = "- "
    }
}
