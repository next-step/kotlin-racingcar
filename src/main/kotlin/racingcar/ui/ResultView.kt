package racingcar.ui

import racingcar.domain.CarHistory

class ResultView {

    fun view(playRecord: List<List<CarHistory>>) {
        println(START_TEXT)
        playRecord.forEach { round ->
            round.forEach { carHistory ->
                printPosition(carHistory.position)
                newLine()
            }
            newLine()
        }
    }

    private fun printPosition(position: Int) = repeat(position + 1) { print(POSITION_TEXT) }
    private fun newLine() = println(NEWLINE_TEXT)

    companion object {
        const val START_TEXT = "실행결과"
        const val POSITION_TEXT = "-"
        const val NEWLINE_TEXT = ""
    }
}
