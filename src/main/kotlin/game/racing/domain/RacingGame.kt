package game.racing.domain

import game.racing.view.InputView
import game.racing.view.ResultView

class RacingGame(private val carManger: CarManger) {
    fun start() {
        val tryNumber = InputView.inputTryNumber()

        ResultView.printResultIntroduction()
        repeat(tryNumber) {
            carManger.moveCars()
            ResultView.printResult(carManger.cars)
        }
    }
}

fun main() {
    val racingGame = RacingGame(CarManger(CarFactory.generateCarByNumberOfCar(InputView.inputNumberOfCar())))
    racingGame.start()
}
