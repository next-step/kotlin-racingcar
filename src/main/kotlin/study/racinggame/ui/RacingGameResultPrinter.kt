package study.racinggame.ui

import study.racinggame.domain.RacingGameResult

object RacingGameResultPrinter {
    fun print(racingGameResult: RacingGameResult) {
        racingGameResult.racingGameStages.forEach { CommandLineRacingGameStagePrinter.print(it) }
        println("${racingGameResult.nameOfWinners().joinToString(separator = ", ")}가 최종 우승했습니다.")
    }
}
