package game

import game.domain.CarFleet
import game.domain.CarNameParser
import game.domain.CarNameValidator
import game.domain.DefaultWinnerFinder
import game.domain.GameResult
import game.domain.History
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
    private val winnerFinder: WinnerFinder = DefaultWinnerFinder()
) {

    fun start() {
        val carFleet = getCars()
        val retryCount = getRetryCount()
        val gameResult = playGame(retryCount, carFleet, winnerFinder)
        userOutputHandler.displayResult(gameResult)
    }

    private fun getRetryCount(): Int =
        userInputHandler.askForRetryCount().let { InputValidator.validateCount(it); it.toInt() }

    private fun getCars(): CarFleet = userInputHandler.askForCarNames().let { CarNameParser.parse(it) }
        .let { CarNameValidator.validate(it); CarFleet.of(it, moveConditionGenerator) }

    private fun playGame(retryCount: Int, carFleet: CarFleet, winnerFinder: WinnerFinder): GameResult {
        var varCarFleet = carFleet
        var history = History()
        repeat(retryCount) {
            varCarFleet = varCarFleet.advanceAll()
            history = history.addRound(varCarFleet.cars)
        }
        val winner = winnerFinder.findWinner(varCarFleet.cars)
        return GameResult(history, winner)
    }
}
