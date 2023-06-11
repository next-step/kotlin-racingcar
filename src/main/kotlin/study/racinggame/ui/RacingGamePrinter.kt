package study.racinggame.ui

import study.racinggame.domain.RacingGameResult

interface RacingGamePrinter {
    fun print(racingGameResult: RacingGameResult)
}
object CommandLineRacingGamePrinter : RacingGamePrinter {
    override fun print(racingGameResult: RacingGameResult) {
        racingGameResult.positionOfCars.forEach { HyphenCarPositionPrinter.print(it) }
        println()
    }
}
