package study.step3

import study.step3.domain.RacingGame
import study.step3.ui.CommandLineRacingGameConfigurator
import study.step3.ui.CommandLineRacingGamePrinter

fun main() {
    val racingGameConfigurator = CommandLineRacingGameConfigurator()
    val racingGameConfiguration = racingGameConfigurator.run()

    val racingGame = RacingGame.of(racingGameConfiguration)

    println("실행 결과")

    racingGame.start(CommandLineRacingGamePrinter())
}
