package domain.step4

import domain.step4.domain.configuration.NumberOfAttempts
import domain.step4.domain.configuration.NumberOfCars
import domain.step4.domain.configuration.RacingCarConfiguration
import domain.step4.domain.game.RacingCarGame
import domain.step4.domain.strategy.RandomNumberMovingStrategy
import domain.step4.ui.RacingCarInputView
import domain.step4.ui.RacingCarResultView
import global.strategy.input.ConsoleInputStrategy
import global.strategy.output.ConsoleOutputStrategy

class RacingCarGameApplication(
    private val inputView: RacingCarInputView,
    private val resultView: RacingCarResultView,
) {

    fun run() {
        val racingCarConfiguration = RacingCarConfiguration(numberOfCars(), numberOfAttempts())
        val racingCarGameRecord = RacingCarGame(racingCarConfiguration, RandomNumberMovingStrategy).run()
        resultView.print(racingCarGameRecord)
    }

    private tailrec fun numberOfAttempts(): NumberOfAttempts {
        return try {
            NumberOfAttempts(inputView.numberOfAttempts())
        } catch (e: Exception) {
            println(e.message)
            numberOfAttempts()
        }
    }

    private tailrec fun numberOfCars(): NumberOfCars {
        return try {
            NumberOfCars(inputView.numberOfCars())
        } catch (e: Exception) {
            println(e.message)
            numberOfCars()
        }
    }
}

fun main() {
    val inputView = RacingCarInputView(ConsoleInputStrategy())
    val resultView = RacingCarResultView(ConsoleOutputStrategy())
    RacingCarGameApplication(inputView, resultView).run()
}
