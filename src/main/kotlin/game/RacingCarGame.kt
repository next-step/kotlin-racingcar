package game

import game.domain.Car
import game.domain.CarFleet
import game.domain.CarNameParser
import game.domain.CarNameValidator
import game.domain.Cars
import game.domain.DefaultWinnerFinder
import game.domain.GameController
import game.domain.GameResult
import game.domain.InputValidator
import game.domain.MoveConditionGenerator
import game.domain.RandomMoveConditionGenerator
import game.domain.WinnerFinder
import game.view.ConsoleInputHandler
import game.view.UserInputHandler
import game.view.UserMessageDisplay
import game.view.UserOutputHandler

class RacingCarGame(
    private val userInputHandler: UserInputHandler = ConsoleInputHandler(),
    private val userOutputHandler: UserOutputHandler = UserMessageDisplay(),
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator(),
    private val winnerFinder: WinnerFinder = DefaultWinnerFinder(),
    private val gameController: GameController = GameController(),
    private val carNameValidator: CarNameValidator = CarNameValidator(),
) {

    fun start() {
        val carNames = getCarNames()
        val carList = carNames.let { carNameValidator.validate(it); Car.from(it) }
        val retryCount = getRetryCount()
        val cars = Cars(carList)
        val carFleet = CarFleet(cars, moveConditionGenerator)
        val history = gameController.playGame(retryCount, carFleet)
        val winners = winnerFinder.findWinner(history.rounds.last())
        userOutputHandler.displayResult(GameResult(history, winners))
    }

    private fun getRetryCount(): Int =
        userInputHandler.askForRetryCount().let { InputValidator.validateCount(it); it.toInt() }

    private fun getCarNames(): List<String> = userInputHandler.askForCarNames().let { CarNameParser.parse(it) }
}
