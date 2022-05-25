package racingcar.ui

import racingcar.domain.CarHistory

class ResultView {

    fun view(playRecord: List<List<CarHistory>>) {
        println(START_TEXT)
        playRecord.forEach { round ->
            round.forEach { carHistory ->
                printCar(carHistory)
                newLine()
            }
            newLine()
        }
    }

    private fun printCar(carHistory: CarHistory) {
        print(carHistory.name + NAME_POSTFIX_TEXT)
        repeat(carHistory.position) { print(POSITION_TEXT) }
    }
    private fun newLine() = println(NEWLINE_TEXT)

    companion object {
        const val START_TEXT = "실행결과"
        const val POSITION_TEXT = "-"
        const val NEWLINE_TEXT = ""
        const val NAME_POSTFIX_TEXT = " : "
    }
}
