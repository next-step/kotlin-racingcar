package racing.controller

import racing.domain.CarsFactory
import racing.domain.Game
import racing.view.GameInputView
import racing.view.GameOutputView

class RacingGameController {
    fun playGame() {
        val nameList = GameInputView.inputNameOfRacingCars()
        val racingRound = GameInputView.inputRacingRound()
        val cars = CarsFactory.createCars(nameList)

        GameOutputView.printStartGame()
        val game = Game(cars, racingRound)
        val gameResult = game.play { GameOutputView.printRaceStatus(it) }
        GameOutputView.printRaceWinner(gameResult.getWinner())
    }
}

fun main() {
    RacingGameController().playGame()
}
