package step3

import step3.domain.car.CarFactory
import step3.domain.car.RandomMovePointDecider
import step3.domain.race.RaceGame
import step3.view.ConsoleInputView
import step3.view.ConsoleResultView
import step3.view.InputView
import step3.view.ResultView

fun main() {
    val inputView: InputView = ConsoleInputView()
    val carCount = inputView.getCarCount()
    val roundCount = inputView.getRoundCount()

    val carList = CarFactory.createCars(carCount, RandomMovePointDecider())

    val raceResult = RaceGame(carList).execute(roundCount)

    val resultView: ResultView = ConsoleResultView()
    resultView.drawResult(raceResult)
}
