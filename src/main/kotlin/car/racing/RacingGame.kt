package car.racing

import car.racing.domain.Car
import car.racing.usecase.Racing
import car.racing.view.InputView
import car.racing.view.ResultView

fun main() {
    val racingGame = RacingGame()

    racingGame.start()
}

class RacingGame {

    private val inputView = InputView()
    private val resultView = ResultView()
    private val racing = Racing()

    fun start() {
        val carCount = inputView.inputCarCount()
        val turnCount = inputView.inputTurnCount()

        val cars = List(carCount) { Car(turnCount) }

        racing.race(cars, turnCount)

        resultView.show(cars, turnCount)
    }
}
