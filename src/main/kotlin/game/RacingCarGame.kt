package game

import game.domain.CarFleet
import game.domain.CarNameParser
import game.domain.CarNameValidator
import game.domain.InputValidator
import game.domain.MoveConditionGenerator
import game.domain.RandomMoveConditionGenerator
import game.view.ConsoleInputHandler
import game.view.UserInputHandler
import game.view.UserMessageDisplay
import game.view.UserOutputHandler

class RacingCarGame(
    private val userInputHandler: UserInputHandler = ConsoleInputHandler(),
    private val userOutputHandler: UserOutputHandler = UserMessageDisplay(),
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator()
) {

    fun start() {
        val cars = getCars()
        val retryCount = getRetryCount()
        val history = cars.advance(retryCount)
        userOutputHandler.displayResult(history)
    }

    private fun getRetryCount(): Int =
        userInputHandler.askForRetryCount().let { InputValidator.validateCount(it); it.toInt() }

    private fun getCars(): CarFleet = userInputHandler.askForCarNames().let { CarNameParser.parse(it) }
        .let { CarNameValidator.validate(it); CarFleet.of(it, moveConditionGenerator) }
}
