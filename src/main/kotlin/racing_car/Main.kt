package racing_car

import racing_car.RacingGame
import racing_car.ui.InputView
import racing_car.ui.ResultView

fun main() {
    InputView.draw(InputView.InputType.CAR)
    val numberCars = readln()

    InputView.draw(InputView.InputType.ROUND)
    val roundCnt = readln()

    ResultView.drawRacingResultMsg()
    RacingGame.run(Triple(numberCars, roundCnt) { carList ->
        ResultView.drawCarPosition(carList)
    })
}
