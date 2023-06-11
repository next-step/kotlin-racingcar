package study.racinggame

import study.racinggame.ui.CommandLineRacingGameConfigurator
import study.racinggame.ui.CommandLineRacingGameStagePrinter
import study.racinggame.ui.RacingGameResultPrinter

fun main() {
    val racingGameConfiguration = CommandLineRacingGameConfigurator.run()
    val racingGame = racingGameConfiguration.build()

    println("실행 결과")

    val racingGameResult = racingGame.start()

    RacingGameResultPrinter.print(racingGameResult)
}
