package racing

import racing.ui.InputView
import racing.ui.ResultView

class RacingCircuit {
    fun race(){
        val inputView = InputView()
        val resultView = ResultView()
        val (carNumber, tryNumber) = inputView.getInputView()

        val racingCars = List(carNumber) { Car() }
        val cars = Cars(racingCars)

        println("레이스 스타트")
        RandomCarRace().move(cars, carNumber, resultView)
    }
}

fun main(){
    RacingCircuit().race()
}