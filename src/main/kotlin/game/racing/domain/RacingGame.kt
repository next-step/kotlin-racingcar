package game.racing.domain

import game.racing.view.InputView
import game.racing.view.ResultView

class RacingGame(private val carManger: CarManger) {
    fun start() {
        val numberOfCar = InputView.inputNumberOfCar()
        carManger.generateCarByNumberOfCar(numberOfCar)
        val tryNumber = InputView.inputTryNumber()

        repeat(tryNumber) {
            carManger.moveCars()
            ResultView.printResult(carManger.cars)
        }
    }
}

fun main() {
    val racingGame = RacingGame(CarManger())
    racingGame.start()
}
