package racingcar.controller

import racingcar.model.RacingCarGame
import racingcar.model.RacingHistories
import racingcar.model.createCars
import racingcar.strategy.MovingStrategy
import racingcar.strategy.RandomNumberMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarController {
    fun startGame() {
        val strategy: MovingStrategy = RandomNumberMovingStrategy()
        val namesOfCars = InputView.getNamesOfCars()
        val numbersOfTry = InputView.getNumbersOfTry()
        val cars = createCars(namesOfCars)
        val game = RacingCarGame(cars, strategy)
        ResultView.printInitial()
        val racingHistories = RacingHistories(game.run(numbersOfTry))
        ResultView.printResult(racingHistories.histories)
        ResultView.printWinner(racingHistories.getWinners())
    }
}
