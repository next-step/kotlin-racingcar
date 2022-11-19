package racingcar.view

import racingcar.domain.RaceStage

private const val SCORE_SYMBOL = "-"
private const val LINE_BREAK = "\n"
private const val WINNER_JOIN_SEPARATOR = ", "

object ResultView {
    fun printResultIntroWording() {
        println()
        println("실행 결과")
    }

    fun printResult(raceStage: RaceStage) {
        val progress = raceStage.cars.joinToString(separator = LINE_BREAK) { car -> "${car.name} : ${SCORE_SYMBOL.repeat(car.pos)}" }
        println(progress)
        println()
    }

    fun printWinner(raceStage: RaceStage) {
        val winnerNames = raceStage.getWinners().joinToString(separator = WINNER_JOIN_SEPARATOR) { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
