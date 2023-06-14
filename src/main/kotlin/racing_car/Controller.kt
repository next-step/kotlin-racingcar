package racing_car

import racing_car.domain.car.CarFactory
import racing_car.domain.car.RandomMovingEngine
import racing_car.domain.race.RaceGame
import racing_car.view.ConsoleInputView
import racing_car.view.ConsoleResultView
import racing_car.view.InputView
import racing_car.view.ResultView

fun main() {
    val inputView: InputView = ConsoleInputView()
    val carNames = inputView.getCarNames()
    val roundCount = inputView.getRoundCount()

    val carList = CarFactory.createCars(carNames, RandomMovingEngine())

    val raceResult = RaceGame(carList).execute(roundCount)

    val resultView: ResultView = ConsoleResultView()
    resultView.drawResult(raceResult)
}
