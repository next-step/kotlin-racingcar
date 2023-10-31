package racing.controller

import racing.car.Car
import racing.car.CarRace
import racing.car.Cars
import racing.ui.InputView
import racing.ui.ResultView

class RacingCircuit {
    fun race() {
        val inputView = InputView()
        val resultView = ResultView()
        val (carNumber, tryNumber) = inputView.getInputView()
        val cars = Cars(carNumber)

        println("레이스 스타트")
        CarRace().randomMove(cars, tryNumber, resultView::makeResultView)
    }

    fun raceWithWinner() {
        val inputView = InputView()
        val resultView = ResultView()
        val (carNames, tryNumber) = inputView.getInputViewWithName()

        val carList = carNames.split(",")
            .map { Car(name = it) }

        val cars = Cars(carList)

        println("실행 결과")
        CarRace().randomMove(cars, tryNumber, resultView::makeResultViewWithName)
        resultView.makeWinnerView(cars)
    }
}

fun main() {
    val racingCircuit = RacingCircuit()
    racingCircuit.raceWithWinner()
}
