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
        for (i in 1..tryNumber) {
            cars.moveAll()
            resultView.makeResultView(cars)
        }
    }
}

fun main(){
    RacingCircuit().race()
}