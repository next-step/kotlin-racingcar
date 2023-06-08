package step3

import step3.domain.car.CarFactory
import step3.domain.formula.BasicRuleMoveFormula
import step3.domain.game.RaceGame
import step3.view.InputView
import step3.view.ResultView
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val (carCount, round) = InputView.readStartInput()

    val cars = CarFactory.createCars(
        count = carCount,
        moveFormula = BasicRuleMoveFormula,
    )

    val raceGame = RaceGame(cars = cars, round = AtomicInteger(round))
    ResultView.printStartGame()

    while (raceGame.isProgress()) {
        val carsPosition = raceGame.race()
        ResultView.printCarsPosition(carsPosition = carsPosition)
    }
}
