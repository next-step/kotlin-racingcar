package racing

import racing.ui.InputView
import racing.ui.ResultView

class RacingCircuit {
    fun race(){
        val inputView = InputView()
        val resultView = ResultView()
        val (carNumber, tryNumber) = inputView.getInputView()
        val cars = Cars(carNumber)

        println("레이스 스타트")
        RandomCarRace().move(cars, tryNumber, resultView::makeResultView)
    }

    fun raceWithWinner(){
        val inputView = InputView()
        val resultView = ResultView()
        val (carNames, tryNumber) = inputView.getInputViewWithName()

        val cars = Cars(carNames)

        println("실행 결과")
        RandomCarRace().move(cars, tryNumber, resultView::makeResultViewWithName)
        resultView.makeWinnerView(cars)
    }
}

fun main(){
    val racingCircuit = RacingCircuit()
    racingCircuit.raceWithWinner()
}