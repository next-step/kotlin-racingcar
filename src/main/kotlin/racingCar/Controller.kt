package racingCar

import racingCar.domain.car.CarFactory
import racingCar.domain.car.RandomMovingEngine
import racingCar.domain.race.RaceGame
import racingCar.view.ConsoleInputView
import racingCar.view.ConsoleResultView
import racingCar.view.InputView
import racingCar.view.ResultView

fun main() {
    val inputView: InputView = ConsoleInputView()
    val carNames = inputView.getCarNames()
    val roundCount = inputView.getRoundCount()

    val carList = CarFactory.createCars(carNames, RandomMovingEngine())

    val raceResult = RaceGame(carList).execute(roundCount)

    val resultView: ResultView = ConsoleResultView()
    resultView.drawResult(raceResult)
}
