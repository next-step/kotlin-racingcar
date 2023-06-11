package study.racinggame

import study.racinggame.ui.CommandLineRacingGameConfigurator
import study.racinggame.ui.CommandLineRacingGamePrinter

fun main() {
    val racingGameConfigurator = CommandLineRacingGameConfigurator()
    val racingGameConfiguration = racingGameConfigurator.run()

    val racingGame = racingGameConfiguration.build()

    println("실행 결과")

    racingGame.start(CommandLineRacingGamePrinter)
}
