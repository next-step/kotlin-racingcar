package step3.main

import step3.racing_car.RacingGame
import step3.racing_car.ui.InputView
import step3.racing_car.ui.ResultView

fun main() {
    InputView.draw(InputView.InputType.CAR)
    val numberCars = readln()

    InputView.draw(InputView.InputType.ROUND)
    val roundCnt = readln()

    ResultView.drawRacingResultMsg()
    RacingGame.run(numberCars, roundCnt) { carList ->
        ResultView.drawCarPosition(carList)
    }
}
