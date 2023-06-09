package step3

import step3.domain.car.CarFactory
import step3.domain.formula.BasicRuleMoveFormula
import step3.domain.game.RaceGame
import step3.domain.generator.RandomNumberGenerator
import step3.view.InputView
import step3.view.ResultView
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val (carCount, round) = InputView.readStartInput()

    val cars = CarFactory.createCars(count = carCount)
    val basicRuleMoveFormula = BasicRuleMoveFormula(numberGenerator = RandomNumberGenerator)

    val raceGame = RaceGame(cars = cars, round = AtomicInteger(round), moveFormula = basicRuleMoveFormula)
    ResultView.printStartGame()

    raceGame.race { raceResult ->
        ResultView.printCarsPosition(carsPosition = raceResult)
    }
}
