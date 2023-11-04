package game.racing.domain

import game.racing.util.getRandomValue
import game.racing.view.InputView
import game.racing.view.ResultView

class RacingGame(private val racingManager: RacingManager, private val tryNumber: Int) {
    fun start() {
        ResultView.printResultIntroduction()
        repeat(tryNumber) {
            racingManager.moveCars(List(racingManager.cars.size) { getRandomValue() })
            ResultView.printResult(racingManager.cars)
        }
    }
}

fun main() {
    val cars = CarFactory.generateCarByNumberOfCar(InputView.inputNumberOfCar())
    val racingGame = RacingGame(RacingManager(cars), InputView.inputTryNumber())
    racingGame.start()
}
