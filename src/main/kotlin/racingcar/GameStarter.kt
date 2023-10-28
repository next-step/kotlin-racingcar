package racingcar

import racingcar.model.RacingCarGame
import racingcar.strategy.MovingStrategy
import racingcar.strategy.RandomNumberMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val strategy: MovingStrategy = RandomNumberMovingStrategy()
    val numbersOfCar = InputView.getNumbersOfCars()
    val numbersOfTry = InputView.getNumbersOfTry()
    val game = RacingCarGame(strategy, numbersOfCar, numbersOfTry)
    val cars = game.start()
    ResultView.printInitial()
    for (car in cars) {
        ResultView.printResult(car.name, car.position)
    }
    ResultView.printEmptyLine()
}
