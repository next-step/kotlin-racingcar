package racingcar.ui

import racingcar.domain.Car

class ResultView {

    fun execute(cars: List<Car>, tryCnt: Int) {
        println(START_TEXT)
        repeat(tryCnt) { retryIndex ->
            cars.forEach { car ->
                if (retryIndex == 0) print(POSITION_TEXT)
                val currentCarHistory = car.histories[retryIndex]
                if (retryIndex > 0 && currentCarHistory.isChange) {
                    printPosition(currentCarHistory.position)
                }
                newLine()
            }
            newLine()
        }
    }

    private fun printPosition(position: Int) = repeat(position + 1) { print(POSITION_TEXT) }
    private fun newLine() = println(NEWLINE_TEXT)

    companion object {
        const val START_TEXT = "\n실행결과"
        const val POSITION_TEXT = "-"
        const val NEWLINE_TEXT = ""
    }
}
