package racingcar.ui

import racingcar.domain.CarHistory
import racingcar.domain.Winner

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
        val winners = Winner(playRecord).winner()
        println(WINNER_TEXT.format(winners.toString()))
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
        const val WINNER_TEXT = "%s가 최종 우승했습니다."
    }
}
