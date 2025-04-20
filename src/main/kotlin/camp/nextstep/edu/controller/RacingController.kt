package camp.nextstep.edu.controller

import camp.nextstep.edu.model.Car
import camp.nextstep.edu.model.RacingGame
import camp.nextstep.edu.view.InputHandler
import camp.nextstep.edu.view.OutputHandler

class RacingController(
    private val inputHandler: InputHandler,
    private val racingGame: RacingGame,
    private val outputHandler: OutputHandler
) {

    fun startGame() {
        val carNames = inputHandler.readCarNames()
        val cars = createCars(carNames)
        val numberOfMoves = inputHandler.getNumberOfMoves()

        outputHandler.displayStartMessage()
        playRounds(cars, numberOfMoves)
        displayResults(cars)
    }

    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map(::Car)
    }

    private fun playRounds(cars: List<Car>, numberOfMoves: Int) {
        repeat(numberOfMoves) { round ->
            outputHandler.displayRoundStartMessage(round + 1)
            racingGame.playRound(cars)
            val positions = racingGame.getCarPositions(cars)
            outputHandler.displayRoundResult(positions)
        }
    }

    private fun displayResults(cars: List<Car>) {
        val winners = racingGame.findWinners(cars)
        outputHandler.displayWinners(winners)
    }
}