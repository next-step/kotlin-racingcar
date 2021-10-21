package domain.step4

import domain.step4.domain.configuration.NumberOfAttempts
import domain.step4.domain.configuration.RacingCarConfiguration
import domain.step4.domain.game.RacingCarGame
import domain.step4.domain.racingcar.Names
import domain.step4.domain.strategy.RandomNumberMovingStrategy
import domain.step4.ui.RacingCarInputView
import domain.step4.ui.RacingCarResultView
import global.strategy.input.ConsoleInputStrategy
import global.strategy.output.ConsoleOutputStrategy
import global.strategy.split.CommaSplitStrategy

class RacingCarGameApplication(
    private val inputView: RacingCarInputView,
    private val resultView: RacingCarResultView,
) {

    fun run() {
        val names = RacingCarConfiguration(names(), numberOfAttempts())
        val racingCarGameRecord = RacingCarGame(names, RandomNumberMovingStrategy).run()
        resultView.print(racingCarGameRecord)
    }

    private tailrec fun names(): Names {
        return try {
            Names.ofStringWithSplitStrategy(inputView.numberOfCars(), CommaSplitStrategy)
        } catch (e: Exception) {
            println(e.message)
            names()
        }
    }

    private tailrec fun numberOfAttempts(): NumberOfAttempts {
        return try {
            NumberOfAttempts(inputView.numberOfAttempts())
        } catch (e: Exception) {
            println(e.message)
            numberOfAttempts()
        }
    }
}

fun main() {
    val inputView = RacingCarInputView(ConsoleInputStrategy())
    val resultView = RacingCarResultView(ConsoleOutputStrategy())
    RacingCarGameApplication(inputView, resultView).run()
}
