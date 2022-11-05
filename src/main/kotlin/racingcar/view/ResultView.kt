package racingcar.view

import racingcar.RaceStage

private const val SCORE_SYMBOL = "-"
private const val LINE_BREAK = "\n"

class ResultView private constructor() {

    companion object {
        fun printResultIntroWording() {
            println()
            println("실행 결과")
        }

        fun printResult(raceStage: RaceStage) {
            val progress = raceStage.cars.joinToString(separator = LINE_BREAK) { car -> SCORE_SYMBOL.repeat(car.pos) }
            println(progress)
            println()
        }
    }
}
