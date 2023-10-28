package racingcar

import racingcar.model.RacingCarGame
import racingcar.strategy.MovingStrategy
import racingcar.strategy.RandomNumberMovingStrategy
import racingcar.view.InputView

fun main() {
    val strategy: MovingStrategy = RandomNumberMovingStrategy()
    val numbersOfCar = InputView.getNumbersOfCars()
    val numbersOfTry = InputView.getNumbersOfTry()
    val game = RacingCarGame(strategy, numbersOfCar, numbersOfTry)
    game.start()
}
