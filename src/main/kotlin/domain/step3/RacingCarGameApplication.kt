package domain.step3

import domain.step3.domain.configuration.NumberOfAttempts
import domain.step3.domain.configuration.NumberOfCars
import domain.step3.domain.configuration.RacingCarConfiguration
import domain.step3.ui.RacingCarInputView
import domain.step3.ui.RacingCarResultView
import global.strategy.input.ConsoleInputStrategy
import global.strategy.output.ConsoleOutputStrategy

class RacingCarGameApplication(
    private val inputView: RacingCarInputView,
    private val resultView: RacingCarResultView
) {

    fun run() {
        val racingCarConfiguration = RacingCarConfiguration(numberOfCars(), numberOfAttempts())
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