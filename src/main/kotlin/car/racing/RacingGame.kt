package car.racing

import car.racing.domain.Car
import car.racing.usecase.NumberMovingStrategy
import car.racing.usecase.NumberRandomGenerator
import car.racing.usecase.Racing
import car.racing.view.InputView
import car.racing.view.ResultView

fun main() {
    RacingGame().start()
}

class RacingGame {

    private val inputView = InputView()
    private val resultView = ResultView()
    private val racing = Racing()

    fun start() {
        val carCount = inputView.inputCarCount()
        val turnCount = inputView.inputTurnCount()

        val carNames = carCount.split(",")
        val cars = carNames.map { name ->
            Car(
                name = name,
                turnCount = turnCount,
                movingStrategy = NumberMovingStrategy(NumberRandomGenerator()),
            )
        }

        racing.race(cars, turnCount)

        resultView.show(cars, turnCount)
    }
}
