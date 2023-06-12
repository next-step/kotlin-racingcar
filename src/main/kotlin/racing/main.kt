package racing

import racing.domain.car.CarFactory
import racing.domain.formula.BasicRuleMoveFormula
import racing.domain.game.RaceGame
import racing.domain.generator.RandomNumberGenerator
import racing.view.CarPositionResult
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val (carNames, round) = InputView.readStartInput()

    val cars = CarFactory.createCars(carNames = carNames)
    val basicRuleMoveFormula = BasicRuleMoveFormula(numberGenerator = RandomNumberGenerator)

    val raceGame = RaceGame(cars = cars, round = round, moveFormula = basicRuleMoveFormula)
    ResultView.printStartGame()

    raceGame.race { raceResult ->
        ResultView.printCarPositionResults(
            results = raceResult.map { CarPositionResult(name = it.name, position = it.position) },
        )
    }

    ResultView.printFinalHeadOfRace(
        headOfRaceCarNames = raceGame.currentHeadOfRace(),
    )
}
