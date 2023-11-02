package game

import game.domain.Car
import game.domain.CarFleet
import game.domain.CarNameParser
import game.domain.CarNameValidator
import game.domain.Cars
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
    private val winnerFinder: WinnerFinder = WinnerFinder(),
    private val gameController: GameController = GameController(),
    private val carNameValidator: CarNameValidator = CarNameValidator(),
) {

    fun start() {
        val carNames = getCarNames()
        val retryCount = getRetryCount()
        val carFleet = getCarFleet(carNames)
        val history = gameController.playGame(retryCount, carFleet)
        val winners = winnerFinder.findWinner(history.rounds.last())
        userOutputHandler.displayResult(GameResult(history, winners))
    }

    private fun getCarFleet(carNames: List<String>) =
        CarFleet(getCars(carNames), moveConditionGenerator)

    private fun getCars(carNames: List<String>) = Cars(getCarList(carNames))

    private fun getCarList(carNames: List<String>) = Car.from(carNames.let { carNameValidator.validate(it); it })

    private fun getRetryCount(): Int =
        userInputHandler.askForRetryCount().let { InputValidator.validateCount(it); it.toInt() }

    private fun getCarNames(): List<String> = userInputHandler.askForCarNames().let { CarNameParser.parse(it) }
}
